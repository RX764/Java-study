package playsong;

import java.util.ArrayList;
import java.util.List;

public class PlayList {
	private String playListName;
	List<Song> musicList;

	public String getPlayListName() {
		return playListName;
	}

	public void setPlayListName(String playListName) {
		this.playListName = playListName;
	}

	public List<Song> getMusicList() {
		return musicList;
	}

	public void setMusicList(List<Song> musicList) {
		this.musicList = musicList;
	}

	// ���췽�� ������ʱ��������б���һ������
	public PlayList(String playListName) {
		super();
		this.playListName = playListName;
		musicList = new ArrayList<Song>();
	}

	// ��Ӹ����������б�
	// �ظ�������
	public void addToPlayList(Song song) {
		Boolean flag = false;
		for (Song s : musicList) {
			if (s.equals(song)) {
				flag = true;
				break;
			}
		}
		if (flag)
			System.out.println("�����Ѿ����ڣ������ظ����");
		else
			musicList.add(song);
	}

	// ��ʾ�����б�ĸ���
	public void displayAllSong() {
		System.out.println("�����б��е����и���Ϊ��");
		for (Song s : musicList)
			System.out.println(s);
	}

	// ͨ��id��ѯ����
	public Song searchSongById(String id) {
		boolean flag = false;
		Song song = null;
		for (Song s : musicList) {
			if (s.getId().equals(id)) {
				flag = true;
				song = s;
				break;
			}
		}
		if (flag) {
			System.out.println("idΪ" + id + "�ĸ�������ϸ��ϢΪ��");
			System.out.println(song);
			return song;
		} else {
			System.out.println("δ�ҵ�������������ѡ�����");
			return null;
		}

	}

	// ͨ�����Ʋ�ѯ
	public Song searchSongByName(String name) {
		boolean flag = false;
		Song song = null;
		for (Song s : musicList) {
			if (s.getName().equals(name)) {
				flag = true;
				song = s;
				break;
			}
		}
		if (flag) {
			System.out.println("������" + name + "��ϸ��ϢΪ��");
			System.out.println(song);
			return song;
		} else {
			System.out.println("δ�ҵ�������������ѡ�����");
			return null;
		}
	}

	// �޸ĸ���
	public void updateSong(String id, Song song) {
		boolean flag = false;
		Song song1 = null;
		for (Song s : musicList) {
			if (s.getId().equals(id)) {
				flag = true;
				song1 = s;
				break;
			}
		}
		if (flag) {
			musicList.remove(song1);
			musicList.add(song);
		}
		System.out.println("���³ɹ�");

	}

	// �Ӳ����б�ɾ��
	public void deleteSong(String id) {
		Song song = searchSongById(id);
		if (song != null) {
			musicList.remove(song);
			System.out.println("ɾ���ɹ�");
		}

	}

	// ���ո���������
//	public void sortBySongName() {
//
//	}

}
