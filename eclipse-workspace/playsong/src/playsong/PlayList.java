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

	// 构造方法 创建的时候给播放列表创建一个名字
	public PlayList(String playListName) {
		super();
		this.playListName = playListName;
		musicList = new ArrayList<Song>();
	}

	// 添加歌曲到播放列表
	// 重复添加情况
	public void addToPlayList(Song song) {
		Boolean flag = false;
		for (Song s : musicList) {
			if (s.equals(song)) {
				flag = true;
				break;
			}
		}
		if (flag)
			System.out.println("歌曲已经存在，请勿重复添加");
		else
			musicList.add(song);
	}

	// 显示播放列表的歌曲
	public void displayAllSong() {
		System.out.println("播放列表中的所有歌曲为：");
		for (Song s : musicList)
			System.out.println(s);
	}

	// 通过id查询歌曲
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
			System.out.println("id为" + id + "的歌曲，详细信息为：");
			System.out.println(song);
			return song;
		} else {
			System.out.println("未找到歌曲，您可以选择添加");
			return null;
		}

	}

	// 通过名称查询
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
			System.out.println("歌曲，" + name + "详细信息为：");
			System.out.println(song);
			return song;
		} else {
			System.out.println("未找到歌曲，您可以选择添加");
			return null;
		}
	}

	// 修改歌曲
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
		System.out.println("更新成功");

	}

	// 从播放列表删除
	public void deleteSong(String id) {
		Song song = searchSongById(id);
		if (song != null) {
			musicList.remove(song);
			System.out.println("删除成功");
		}

	}

	// 按照歌曲名排序
//	public void sortBySongName() {
//
//	}

}
