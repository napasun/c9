package board.dao.boardgroup;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import board.model.board.boardgroup.BoardGroup;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class AfterSelectBoardGroupTest {
	private static BoardGroupDao boardGroupDao;
	private static List<BoardGroup> boardParamList;
	
	private static BoardGroup setBoardGroup(Integer boardNum, String boardName) {
		return new BoardGroup(boardNum, boardName);
	}
	
	private static Integer BoardNum(Integer boardNum) { return boardNum;}
	
	private static String BoardName(String boardName) { return boardName;}
	
	private int BoardSize(int size) { return size;}
	
	@BeforeClass
	public static void dbSetUp() {
		boardGroupDao = new BoardGroupDao();
	}
	
	@BeforeClass
	public static void paramSetUp() {
		boardParamList = new ArrayList<BoardGroup>();
		
		boardParamList.add(setBoardGroup(BoardNum(2), BoardName("insertTest")));
		boardParamList.add(setBoardGroup(BoardNum(3), BoardName("insertTest2")));
	}

	
	@Test
	public void AselectBoardGroupTest() {
		List<BoardGroup> list = boardGroupDao.selectBoardList(setBoardGroup(BoardNum(1), BoardName("")));
		
		assertEquals("값이 없네요", list.size(), BoardSize(1));
		assertEquals("뭘 찾은 건가요?", list.get(0).getBoardName(), BoardName("test"));
	}
	
	
	@Test
	public void BinsertBoardGroupTest() {	
		for (BoardGroup boardParam : boardParamList) {
			List<BoardGroup> list = boardGroupDao.selectBoardList(boardParam);
			assertEquals("이미 값이 들어가 있습니다.", list.size(), BoardSize(0));
			
			boardGroupDao.insertBoard(boardParam);				
			list = boardGroupDao.selectBoardList(boardParam.getBoardNum());
			
			assertEquals("값이 안 들어갔어요", list.size(), BoardSize(1));
			assertEquals("이상한 값이 들어갔네요.", list.get(0).getBoardName(), boardParam.getBoardName());
		}	
	}
	
	@Test
	public void CdeleteBoardGroupTest() {
		for (BoardGroup boardParam : boardParamList) {
			boardGroupDao.deleteBoardGroup(boardParam.getBoardNum());

			List<BoardGroup> list = boardGroupDao.selectBoardList(boardParam.getBoardNum());
			
			assertEquals("삭제가 안됬구만", list.size(), BoardSize(0));
		}	
	}
}
