package playsong;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Scanner;

public class testdemo {
//������
	public void testsong() {
		Song song1 = new Song("S001", "dream it possible", "����ӱ");
		Song song2 = new Song("S002", "��Ա", "Ѧ֮ǫ");
		Song song3 = new Song("S003", "����", "�Ž�");
		Song song4 = new Song("S003", "����", "�Ž�");

		System.out.println(song1);
		System.out.println(song1.equals(song3));
		System.out.println(song4.equals(song3));
	}

	public void testPlayList() {
		Song song1 = new Song("S001", "dream it possible", "����ӱ");
		Song song2 = new Song("S002", "��Ա", "Ѧ֮ǫ");
		Song song3 = new Song("S003", "����", "�Ž�");
		Song song4 = new Song("S004", "����", "�Ž�");
		PlayList playlist = new PlayList("�������б�");
		playlist.addToPlayList(song1);
		playlist.addToPlayList(song2);
		playlist.addToPlayList(song3);
		playlist.addToPlayList(song4);
		playlist.displayAllSong();
		playlist.searchSongById("S001");
		playlist.searchSongByName("����");
		playlist.deleteSong("S004");
		playlist.displayAllSong();
	}

	public void collectiontest() {
		Song song1 = new Song("S001", "dream it possible", "����ӱ");
		Song song2 = new Song("S002", "��Ա", "Ѧ֮ǫ");
		Song song3 = new Song("S003", "����", "�Ž�");
		Song song4 = new Song("S004", "����", "�Ž�");
		PlayList mainPlayList = new PlayList("�������б�");
		mainPlayList.addToPlayList(song1);
		mainPlayList.addToPlayList(song2);
		mainPlayList.addToPlayList(song3);
		mainPlayList.addToPlayList(song4);

		PlayList like = new PlayList("��ϲ����");
		like.addToPlayList(mainPlayList.getMusicList().get(0));
		like.addToPlayList(mainPlayList.getMusicList().get(1));
		like.displayAllSong();

		// �������б���ӵ�������
		PlayListCollection plc = new PlayListCollection();
		plc.addPlayList(mainPlayList);
		plc.addPlayList(like);
		plc.displayListName();
		PlayList loveList = plc.searchPlayListByName("��ϲ����");
		loveList.displayAllSong();
	}

	// ���˵�
	public void mainMenu() {
		System.out.println("******************************************");
		System.out.println("*\t\t**���˵�**\t\t*");
		System.out.println("\t1-�����б����");
		System.out.println("\t2-����������");
		System.out.println("\t0-�˳�ϵͳ");
//		System.out.println("\t\t4-�����б����");
		System.out.println("******************************************");

	}

	// �����б����
	public void playlistmenu() {
		System.out.println("******************************************");
		System.out.println("*\t\t**�����б����**\t\t*");
		System.out.println("\t1-��Ӹ������������б�");
		System.out.println("\t2-��Ӹ�������ͨ�����б�");
		System.out.println("\t3-ͨ��ID��ѯ����");
		System.out.println("\t4-ͨ��������ѯ����");
		System.out.println("\t5-�޸ĸ���");
		System.out.println("\t6-ɾ������");
		System.out.println("\t7-��ʾ���б����и���");
		System.out.println("\t8-�����ϼ��˵�");
		System.out.println("\t9-�����赥");
		System.out.println("******************************************");
	}

	// ����������˵�
	public void playermenu() {
		System.out.println("******************************************");
		System.out.println("*\t\t**����������**\t\t*");
		System.out.println("\t1-��Ӳ����б�");
		System.out.println("\t2-ɾ�������б�");
		System.out.println("\t3-ͨ�����ֲ�ѯ�����б�");
		System.out.println("\t4-��ʾ�����б�����");
		System.out.println("\t8-�����ϼ��˵�");
		System.out.println("******************************************");
	}

	// ��ҵ������
	public void test() {
		testdemo testdemo = new testdemo();
		Scanner in = new Scanner(System.in);
		int input = 0, input1 = 0, input2 = 0;
		PlayListCollection plc = new PlayListCollection();
		PlayList mainPlayList = new PlayList("�������б�");
		plc.addPlayList(mainPlayList);
		PlayList myList = null;
		while (true) {
			testdemo.mainMenu();
			System.out.println("�������Ӧ���ֲ���");
			try {
				input = Integer.parseInt(in.next());
				if (input == 0) {
					System.out.println("�˳�ϵͳ");
					break;
				}

			} catch (NumberFormatException e) {
				// TODO: handle exception
				System.out.println("��������ȷ������");

			} catch (Exception e) {
//				testdemo.mainMenu();
				System.out.println("�˳�ϵͳ");
			}

			switch (input) {
			case 1:
				// �����б�
				while (true) {
					testdemo.playlistmenu();
					try {
						input1 = Integer.parseInt(in.next());
						if (input1 == 8)
							break;
					} catch (NumberFormatException e) {
						// TODO: handle exception
						System.out.println("��������ȷ������");
					} catch (Exception e) {
						// TODO Auto-generated catch block
						testdemo.playlistmenu();
					}
					switch (input1) {
					case 1:
						System.out.println("��������ӵ��������б�");
						System.out.println("��������Ӹ���������");
						int count = in.nextInt();
						for (int i = 0; i < count; i++) {
							System.out.println("��" + (i + 1) + "�׸���");
							System.out.print("����ID��");
							String strid = in.next();
							System.out.print("������");
							String strname = in.next();
							System.out.print("���֣�");
							String strsinger = in.next();
							Song song = new Song(strid, strname, strsinger);
							mainPlayList.addToPlayList(song);
//							mainPlayList.displayAllSong();
						}
						break;
					case 2:
						System.out.println("��������ӵ���ͨ�����б�");
						System.out.println("��ѡ�񲥷��б�");
						String sname = in.next();
						myList = plc.searchPlayListByName(sname);
						if (myList == null)
							System.out.println("�б����ڣ��������");
						else {
							System.out.println("��������Ӹ���������");
							int count1 = in.nextInt();
							for (int i = 0; i < count1; i++) {
								System.out.println("��" + (i + 1) + "�׸���");
								System.out.print("����ID��");
								String strid = in.next();
								Song song = mainPlayList.searchSongById(strid);
								if (null == song) {
									System.out.println("�ø������������б����ڣ�������������Ϣ");
									System.out.print("������");
									String strname = in.next();
									System.out.print("���֣�");
									String strsinger = in.next();
									song = new Song(strid, strname, strsinger);
									mainPlayList.addToPlayList(song);
									myList.addToPlayList(song);
									mainPlayList.addToPlayList(song);
								} else {
									myList.addToPlayList(song);
								}
							}
//							System.out.println("�������б�");
//							mainPlayList.displayAllSong();
//							System.out.println("��ͨ�����б�");
//							myList.displayAllSong();
						}
						break;
					case 3:
						System.out.println("ͨ��ID��ѯ����");
						System.out.println("��������Ҫ���ҵĲ����б�");
						String strplaylistname1 = in.next();
						PlayList pl = plc.searchPlayListByName(strplaylistname1);
						if (pl == null) {
							System.out.println("�����б�����");
							break;
						} else {
							System.out.println("��������Ҫ���ҵĸ���ID");
							String strID1 = in.next();
							Song s = pl.searchSongById(strID1);
							if (s == null) {
								System.out.println("�ø����ڴ˲����б�����");
								break;
							} else {
								System.out.println("������ϢΪ");
								System.out.println(s);
							}
						}
						break;
					case 4:
						System.out.println("ͨ��������ѯ����");

						System.out.println("��������Ҫ���ҵĲ����б�");
						String strplaylistname2 = in.next();
						PlayList pl2 = plc.searchPlayListByName(strplaylistname2);
						if (pl2 == null) {
							System.out.println("�����б�����");
							break;
						} else {
							System.out.println("��������Ҫ���ҵĸ�������");
							String strname = in.next();
							Song s2 = pl2.searchSongByName(strname);
							if (s2 == null) {
								System.out.println("�ø����ڴ˲����б�����");
								break;
							} else {
								System.out.println("������ϢΪ");
								System.out.println(s2);
							}
						}

						break;
					case 5:
						System.out.println("�޸ĸ�����Ϣ");
						System.out.println("��������Ҫ�޸ĵĲ����б�");
						String strplaylistname3 = in.next();
						PlayList pl3 = plc.searchPlayListByName(strplaylistname3);
						PlayList plmain = plc.searchPlayListByName("�������б�");
						if (pl3 == null) {
							System.out.println("�����б�����");
							break;
						} else {
							System.out.println("��������Ҫ�޸ĵĸ�����Ϣ");
							System.out.print("����ID��");
							String strid = in.next();
							System.out.print("������");
							String strname = in.next();
							System.out.print("���֣�");
							String strsinger = in.next();
							Song s = pl3.searchSongById(strid);
							if (s == null) {
								System.out.println("���������ڣ��޸�ʧ��");
								break;
							} else {
								Song song = new Song(strid, strname, strsinger);
								pl3.updateSong(strid, song);
								plmain.updateSong(strid, song);
							}
						}

						break;
					case 6:
						System.out.println("ɾ������");
						System.out.println("��������Ҫ�޸ĵĲ����б�");
						String strplaylistname4 = in.next();
						PlayList pl4 = plc.searchPlayListByName(strplaylistname4);
						if (pl4 == null) {
							System.out.println("�����б�����");
							break;
						} else {
							System.out.println("��������Ҫɾ���ĸ���ID");
							String songID = in.next();
							Song s = pl4.searchSongById(songID);
							if (s == null) {
								System.out.println("���б�û�иø���");
							} else {
								pl4.deleteSong(songID);
							}
						}

						break;
					case 7:
						System.out.println("��ʾ���б����и���");

						System.out.println("��������Ҫ��ʾ�Ĳ����б�");
						String strplaylistname5 = in.next();
						PlayList pl5 = plc.searchPlayListByName(strplaylistname5);
//						for (Song s : pl5.getMusicList()) {
//							System.out.println("playlist��" + s);
//						}
						if (pl5 == null) {
							System.out.println("�����б�����");
						} else {
							System.out.println("�б��еĸ����У�");
							pl5.displayAllSong();
						}
						break;
					case 9:
						System.out.println("�����赥");
						System.out.println("��������Ҫ�����Ĳ����б�");
						String strplaylistname6 = in.next();
						PlayList pl6 = plc.searchPlayListByName(strplaylistname6);
						if (pl6 == null) {
							System.out.println("�����б�����");
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
								System.out.println("�����ļ�ʧ��");
							}

						}

						break;
					default:
						System.out.println("��Ч����");
						break;
					}

				}
				break;
			case 2:
				// ������
				while (true) {
					testdemo.playermenu();
					try {
//						input2 = in.nextInt();
						input2 = Integer.parseInt(in.next());
						if (input2 == 8)
							break;
					} catch (NumberFormatException e) {
						System.out.println("��������Ч����");
						// TODO: handle exception
					} catch (Exception e) {
						// TODO Auto-generated catch block
						testdemo.playermenu();
					}
					switch (input2) {
					case 1:
						System.out.println("��Ӳ����б�");
						String playListName = in.next();
						myList = new PlayList(playListName);
						plc.addPlayList(myList);
						break;
					case 2:
						System.out.println("ɾ�������б�");
						System.out.println("������ɾ�������б�����");
						String name1 = in.next();
						PlayList playList = plc.searchPlayListByName(name1);
						if (name1.equals("�������б�")) {
							System.out.println("�������б���ɾ��");
							break;
						}
						if (playList == null) {
							System.out.println("���б�����");
						} else {
							plc.deletePlayList(playList);
						}
						break;
					case 3:
						System.out.println("ͨ�����ֲ�ѯ�����б�");
						System.out.println("�������ѯ�����б�����");
						String name2 = in.next();
						PlayList playList2 = plc.searchPlayListByName(name2);
						if (playList2 == null)
							System.out.println("���б�����");
						else {
							System.out.println(name2);
							playList2.displayAllSong();
						}
						break;
					case 4:
						System.out.println("��ʾ�����б�����");
						System.out.println("�Ѵ��ڵ�ʾ�����б�");
						plc.displayListName();
						break;
					default:
						System.out.println("��Ч����");
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
