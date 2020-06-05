package playsong;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

//�����б�
public class PlayListCollection {
	private Map<String, PlayList> playListMap;

	public Map<String, PlayList> getPlayListMap() {
		return playListMap;
	}

	public void setPlayListMap(Map<String, PlayList> playListMap) {
		this.playListMap = playListMap;
	}

	public PlayListCollection(Map<String, PlayList> playListMap) {
		super();
		this.playListMap = playListMap;
	}

	public PlayListCollection() {
		playListMap = new HashMap<String, PlayList>();
	}

	public void addPlayList(PlayList playList) {
		playListMap.put(playList.getPlayListName(), playList);

	}

	public void deletePlayList(PlayList playList) {
		playListMap.remove(playList.getPlayListName());
		System.out.println("ɾ���ɹ�");

	}

	public PlayList searchPlayListByName(String playListName) {
		PlayList pl = null;
		Set<String> plaSet = playListMap.keySet();// ȡ��KEY�鿴�Ƿ����
		for (String s : plaSet) {
			if (s.equals(playListName)) {
				pl = playListMap.get(s);
				break;
			}
		}
		return pl;
	}

	public void displayListName() {
		Set<String> playSet = playListMap.keySet();
		System.out.println("����ӵ�еĲ����б�");
		for (String s : playSet) {
			System.out.println(s);
		}

	}

}
