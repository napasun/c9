package board.model.board.boardgroup;

public class BoardGroup {
	public static enum Column {
		boardNum, boardName;
	}
	
	private Integer boardNum;
	private String boardName;
	
	public BoardGroup() {}
	
	public BoardGroup(Integer boardNum) {
		this.boardNum = boardNum;
		this.boardName = "";
	}
	
	public BoardGroup(String boardName) {
		this.boardNum = 0;
		this.boardName = boardName;
	}
	
	public BoardGroup(Integer boardNum, String boardName) {
		this.boardNum = boardNum;
		this.boardName = boardName;
	}
	
	public Integer getBoardNum() {
		return boardNum;
	}
	public void setBoardNum(Integer boardNum) {
		this.boardNum = boardNum;
	}
	public String getBoardName() {
		return boardName;
	}
	public void setBoardName(String boardName) {
		this.boardName = boardName;
	}
}
