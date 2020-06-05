package playsong;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Scanner;

public class testdemo {
//测试类
	public void testsong() {
		Song song1 = new Song("S001", "dream it possible", "张靓颖");
		Song song2 = new Song("S002", "演员", "薛之谦");
		Song song3 = new Song("S003", "天下", "张杰");
		Song song4 = new Song("S003", "天下", "张杰");

		System.out.println(song1);
		System.out.println(song1.equals(song3));
		System.out.println(song4.equals(song3));
	}

	public void testPlayList() {
		Song song1 = new Song("S001", "dream it possible", "张靓颖");
		Song song2 = new Song("S002", "演员", "薛之谦");
		Song song3 = new Song("S003", "天下", "张杰");
		Song song4 = new Song("S004", "三国", "张杰");
		PlayList playlist = new PlayList("主播放列表");
		playlist.addToPlayList(song1);
		playlist.addToPlayList(song2);
		playlist.addToPlayList(song3);
		playlist.addToPlayList(song4);
		playlist.displayAllSong();
		playlist.searchSongById("S001");
		playlist.searchSongByName("天下");
		playlist.deleteSong("S004");
		playlist.displayAllSong();
	}

	public void collectiontest() {
		Song song1 = new Song("S001", "dream it possible", "张靓颖");
		Song song2 = new Song("S002", "演员", "薛之谦");
		Song song3 = new Song("S003", "天下", "张杰");
		Song song4 = new Song("S004", "三国", "张杰");
		PlayList mainPlayList = new PlayList("主播放列表");
		mainPlayList.addToPlayList(song1);
		mainPlayList.addToPlayList(song2);
		mainPlayList.addToPlayList(song3);
		mainPlayList.addToPlayList(song4);

		PlayList like = new PlayList("我喜爱的");
		like.addToPlayList(mainPlayList.getMusicList().get(0));
		like.addToPlayList(mainPlayList.getMusicList().get(1));
		like.displayAllSong();

		// 将播放列表添加到集合中
		PlayListCollection plc = new PlayListCollection();
		plc.addPlayList(mainPlayList);
		plc.addPlayList(like);
		plc.displayListName();
		PlayList loveList = plc.searchPlayListByName("我喜爱的");
		loveList.displayAllSong();
	}

	// 主菜单
	public void mainMenu() {
		System.out.println("******************************************");
		System.out.println("*\t\t**主菜单**\t\t*");
		System.out.println("\t1-播放列表管理");
		System.out.println("\t2-播放器管理");
		System.out.println("\t0-退出系统");
//		System.out.println("\t\t4-播放列表管理");
		System.out.println("******************************************");

	}

	// 播放列表管理
	public void playlistmenu() {
		System.out.println("******************************************");
		System.out.println("*\t\t**播放列表管理**\t\t*");
		System.out.println("\t1-添加歌曲到主播放列表");
		System.out.println("\t2-添加歌曲到普通播放列表");
		System.out.println("\t3-通过ID查询歌曲");
		System.out.println("\t4-通过歌名查询歌曲");
		System.out.println("\t5-修改歌曲");
		System.out.println("\t6-删除歌曲");
		System.out.println("\t7-显示该列表所有歌曲");
		System.out.println("\t8-返回上级菜单");
		System.out.println("\t9-导出歌单");
		System.out.println("******************************************");
	}

	// 播放器管理菜单
	public void playermenu() {
		System.out.println("******************************************");
		System.out.println("*\t\t**播放器管理**\t\t*");
		System.out.println("\t1-添加播放列表");
		System.out.println("\t2-删除播放列表");
		System.out.println("\t3-通过名字查询播放列表");
		System.out.println("\t4-显示播放列表名字");
		System.out.println("\t8-返回上级菜单");
		System.out.println("******************************************");
	}

	// 主业务流程
	public void test() {
		testdemo testdemo = new testdemo();
		Scanner in = new Scanner(System.in);
		int input = 0, input1 = 0, input2 = 0;
		PlayListCollection plc = new PlayListCollection();
		PlayList mainPlayList = new PlayList("主播放列表");
		plc.addPlayList(mainPlayList);
		PlayList myList = null;
		while (true) {
			testdemo.mainMenu();
			System.out.println("请输入对应数字操作");
			try {
				input = Integer.parseInt(in.next());
				if (input == 0) {
					System.out.println("退出系统");
					break;
				}

			} catch (NumberFormatException e) {
				// TODO: handle exception
				System.out.println("请输入正确的数字");

			} catch (Exception e) {
//				testdemo.mainMenu();
				System.out.println("退出系统");
			}

			switch (input) {
			case 1:
				// 播放列表
				while (true) {
					testdemo.playlistmenu();
					try {
						input1 = Integer.parseInt(in.next());
						if (input1 == 8)
							break;
					} catch (NumberFormatException e) {
						// TODO: handle exception
						System.out.println("请输入正确的数字");
					} catch (Exception e) {
						// TODO Auto-generated catch block
						testdemo.playlistmenu();
					}
					switch (input1) {
					case 1:
						System.out.println("将歌曲添加到主播放列表");
						System.out.println("请输入添加歌曲的数量");
						int count = in.nextInt();
						for (int i = 0; i < count; i++) {
							System.out.println("第" + (i + 1) + "首歌曲");
							System.out.print("歌曲ID：");
							String strid = in.next();
							System.out.print("歌名：");
							String strname = in.next();
							System.out.print("歌手：");
							String strsinger = in.next();
							Song song = new Song(strid, strname, strsinger);
							mainPlayList.addToPlayList(song);
//							mainPlayList.displayAllSong();
						}
						break;
					case 2:
						System.out.println("将歌曲添加到普通播放列表");
						System.out.println("请选择播放列表");
						String sname = in.next();
						myList = plc.searchPlayListByName(sname);
						if (myList == null)
							System.out.println("列表不存在，请先添加");
						else {
							System.out.println("请输入添加歌曲的数量");
							int count1 = in.nextInt();
							for (int i = 0; i < count1; i++) {
								System.out.println("第" + (i + 1) + "首歌曲");
								System.out.print("歌曲ID：");
								String strid = in.next();
								Song song = mainPlayList.searchSongById(strid);
								if (null == song) {
									System.out.println("该歌曲在主播放列表不存在，请输入其他信息");
									System.out.print("歌名：");
									String strname = in.next();
									System.out.print("歌手：");
									String strsinger = in.next();
									song = new Song(strid, strname, strsinger);
									mainPlayList.addToPlayList(song);
									myList.addToPlayList(song);
									mainPlayList.addToPlayList(song);
								} else {
									myList.addToPlayList(song);
								}
							}
//							System.out.println("主播放列表：");
//							mainPlayList.displayAllSong();
//							System.out.println("普通播放列表：");
//							myList.displayAllSong();
						}
						break;
					case 3:
						System.out.println("通过ID查询歌曲");
						System.out.println("请输入需要查找的播放列表");
						String strplaylistname1 = in.next();
						PlayList pl = plc.searchPlayListByName(strplaylistname1);
						if (pl == null) {
							System.out.println("播放列表不存在");
							break;
						} else {
							System.out.println("请输入需要查找的歌曲ID");
							String strID1 = in.next();
							Song s = pl.searchSongById(strID1);
							if (s == null) {
								System.out.println("该歌曲在此播放列表不存在");
								break;
							} else {
								System.out.println("歌曲信息为");
								System.out.println(s);
							}
						}
						break;
					case 4:
						System.out.println("通过歌名查询歌曲");

						System.out.println("请输入需要查找的播放列表");
						String strplaylistname2 = in.next();
						PlayList pl2 = plc.searchPlayListByName(strplaylistname2);
						if (pl2 == null) {
							System.out.println("播放列表不存在");
							break;
						} else {
							System.out.println("请输入需要查找的歌曲名称");
							String strname = in.next();
							Song s2 = pl2.searchSongByName(strname);
							if (s2 == null) {
								System.out.println("该歌曲在此播放列表不存在");
								break;
							} else {
								System.out.println("歌曲信息为");
								System.out.println(s2);
							}
						}

						break;
					case 5:
						System.out.println("修改歌曲信息");
						System.out.println("请输入需要修改的播放列表");
						String strplaylistname3 = in.next();
						PlayList pl3 = plc.searchPlayListByName(strplaylistname3);
						PlayList plmain = plc.searchPlayListByName("主播放列表");
						if (pl3 == null) {
							System.out.println("播放列表不存在");
							break;
						} else {
							System.out.println("请输入需要修改的歌曲信息");
							System.out.print("歌曲ID：");
							String strid = in.next();
							System.out.print("歌名：");
							String strname = in.next();
							System.out.print("歌手：");
							String strsinger = in.next();
							Song s = pl3.searchSongById(strid);
							if (s == null) {
								System.out.println("歌曲不存在，修改失败");
								break;
							} else {
								Song song = new Song(strid, strname, strsinger);
								pl3.updateSong(strid, song);
								plmain.updateSong(strid, song);
							}
						}

						break;
					case 6:
						System.out.println("删除歌曲");
						System.out.println("请输入需要修改的播放列表");
						String strplaylistname4 = in.next();
						PlayList pl4 = plc.searchPlayListByName(strplaylistname4);
						if (pl4 == null) {
							System.out.println("播放列表不存在");
							break;
						} else {
							System.out.println("请输入需要删除的歌曲ID");
							String songID = in.next();
							Song s = pl4.searchSongById(songID);
							if (s == null) {
								System.out.println("此列表没有该歌曲");
							} else {
								pl4.deleteSong(songID);
							}
						}

						break;
					case 7:
						System.out.println("显示该列表所有歌曲");

						System.out.println("请输入需要显示的播放列表");
						String strplaylistname5 = in.next();
						PlayList pl5 = plc.searchPlayListByName(strplaylistname5);
//						for (Song s : pl5.getMusicList()) {
//							System.out.println("playlist：" + s);
//						}
						if (pl5 == null) {
							System.out.println("播放列表不存在");
						} else {
							System.out.println("列表中的歌曲有：");
							pl5.displayAllSong();
						}
						break;
					case 9:
						System.out.println("导出歌单");
						System.out.println("请输入需要导出的播放列表");
						String strplaylistname6 = in.next();
						PlayList pl6 = plc.searchPlayListByName(strplaylistname6);
						if (pl6 == null) {
							System.out.println("播放列表不存在");
						} else {
							try {
								File f1 = new File(strplaylistname6 + ".txt");
								f1.createNewFile();
								FileOutputStream fos = new FileOutputStream(f1);
								for (Song s : pl6.getMusicList()) {
									fos.write(s.toString().getBytes());
									fos.write("\r\n".getBytes());
								}
							} catch (FileNotFoundException e) {
								System.exit(-1);
							} catch (IOException e) {
								// TODO Auto-generated catch block
								System.out.println("创建文件失败");
							}

						}

						break;
					default:
						System.out.println("无效数字");
						break;
					}

				}
				break;
			case 2:
				// 播放器
				while (true) {
					testdemo.playermenu();
					try {
//						input2 = in.nextInt();
						input2 = Integer.parseInt(in.next());
						if (input2 == 8)
							break;
					} catch (NumberFormatException e) {
						System.out.println("请输入有效数字");
						// TODO: handle exception
					} catch (Exception e) {
						// TODO Auto-generated catch block
						testdemo.playermenu();
					}
					switch (input2) {
					case 1:
						System.out.println("添加播放列表");
						String playListName = in.next();
						myList = new PlayList(playListName);
						plc.addPlayList(myList);
						break;
					case 2:
						System.out.println("删除播放列表");
						System.out.println("请输入删除播放列表名称");
						String name1 = in.next();
						PlayList playList = plc.searchPlayListByName(name1);
						if (name1.equals("主播放列表")) {
							System.out.println("主播放列表不能删除");
							break;
						}
						if (playList == null) {
							System.out.println("该列表不存在");
						} else {
							plc.deletePlayList(playList);
						}
						break;
					case 3:
						System.out.println("通过名字查询播放列表");
						System.out.println("请输入查询播放列表名称");
						String name2 = in.next();
						PlayList playList2 = plc.searchPlayListByName(name2);
						if (playList2 == null)
							System.out.println("该列表不存在");
						else {
							System.out.println(name2);
							playList2.displayAllSong();
						}
						break;
					case 4:
						System.out.println("显示播放列表名字");
						System.out.println("已存在的示播放列表：");
						plc.displayListName();
						break;
					default:
						System.out.println("无效数字");
						break;
					}
				}
			}

		}

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		testdemo td = new testdemo();
//		td.testsong();
//		td.testPlayList();
//		td.collectiontest();
		td.test();
	}

}
