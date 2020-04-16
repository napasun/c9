package board.dao.boardgroup;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.Test;

import board.model.board.boardgroup.BoardGroup;

public class BoardGroupTest {
	@Test
	public void selectBoardGroupTest() {
		BoardGroupDao boardGroupDao = new BoardGroupDao();
		
		BoardGroup selectParam = new BoardGroup(1, "");
		List<BoardGroup> list = boardGroupDao.selectBoardList(selectParam);
		
		assertEquals(list.size(), 1);
		assertEquals(list.get(0).getBoardName(), "test");
	}
	
	@Test
	public void insertBoardGroupTest() {
		BoardGroupDao boardGroupDao = new BoardGroupDao();
		
		BoardGroup selectParam = new BoardGroup(2, "");
		List<BoardGroup> list = boardGroupDao.selectBoardList(selectParam);
		assertEquals(list.size(), 0);
		
		
		BoardGroup insertParam = new BoardGroup(2, "insertTest");
		boardGroupDao.insertBoard(insertParam);
		
		
		list = boardGroupDao.selectBoardList(selectParam);
		assertEquals(list.size(), 1);
		assertEquals(list.get(0).getBoardName(), "insertTest");
		
		
		boardGroupDao.deleteBoardGroup(2);
		
		list = boardGroupDao.selectBoardList(selectParam);
		assertEquals(list.size(), 0);
	}
}
