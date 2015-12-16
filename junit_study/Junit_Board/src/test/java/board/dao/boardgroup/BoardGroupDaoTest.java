package board.dao.boardgroup;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.Test;

import board.model.board.boardgroup.BoardGroup;

public class BoardGroupDaoTest {
	@Test
	public void selectBoardGroupTest() {
		BoardGroupDao boardGroupDao = new BoardGroupDao();
		
		BoardGroup selectParam = new BoardGroup(1, "");
		List<BoardGroup> list = boardGroupDao.selectBoardList(selectParam);
		
		assertEquals(list.size(), 1);
		assertEquals(list.get(0).getBoardName(), "test");
	}
	
	@Test
	public void CRDBoardGroupTest() {
		BoardGroupDao boardGroupDao = new BoardGroupDao();
		BoardGroup insertParam = new BoardGroup(2, "insertTest");
		
		boardGroupDao.insertBoard(insertParam);
		
		BoardGroup selectParam = new BoardGroup(2, "");
		List<BoardGroup> list = boardGroupDao.selectBoardList(selectParam);
		
		assertEquals(list.size(), 1);
		assertEquals(list.get(0).getBoardName(), "insertTest");
		
		boardGroupDao.deleteBoardGroup(2);
		
		list = boardGroupDao.selectBoardList(selectParam);
		assertEquals(list.size(), 0);
	}
	

	private Integer getBoardNum(Integer boardNum) {
		return boardNum;
	}
	
	private String getBoardName(String boardName) {
		return boardName;
	}
	
	private int getListSize(int size) {
		return size;
	}
	
	@Test
	public void afterSelectBoardGroupTest() {
		BoardGroupDao boardGroupDao = new BoardGroupDao();
		
		BoardGroup selectParam = new BoardGroup(getBoardNum(1), getBoardName(""));
		List<BoardGroup> list = boardGroupDao.selectBoardList(selectParam);
		
		assertEquals(list.size(), getListSize(1));
		assertEquals(list.get(0).getBoardName(), getBoardName("test"));
	}
	
	
}
