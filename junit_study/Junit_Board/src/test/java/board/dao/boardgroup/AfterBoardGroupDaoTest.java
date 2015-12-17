package board.dao.boardgroup;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.Test;

import board.model.board.boardgroup.BoardGroup;

public class AfterBoardGroupDaoTest {
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
