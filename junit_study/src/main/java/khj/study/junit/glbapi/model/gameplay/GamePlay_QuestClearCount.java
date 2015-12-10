package khj.study.junit.glbapi.model.gameplay;

import khj.study.junit.glbapi.model.Common;

public class GamePlay_QuestClearCount extends Common {
	int QuestType;
	int QuestSubIdx;
	public int getQuestType() {
		return QuestType;
	}
	public void setQuestType(int questType) {
		QuestType = questType;
	}
	public int getQuestSubIdx() {
		return QuestSubIdx;
	}
	public void setQuestSubIdx(int questSubIdx) {
		QuestSubIdx = questSubIdx;
	}
	public int getClearCount() {
		return ClearCount;
	}
	public void setClearCount(int clearCount) {
		ClearCount = clearCount;
	}
	int ClearCount;
}
