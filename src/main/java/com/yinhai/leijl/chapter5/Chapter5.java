package com.yinhai.leijl.chapter5;

import com.yinhai.leijl.*;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collector;
import java.util.stream.Stream;

import static java.util.stream.Collectors.*;

public class Chapter5 {

    //5.3.2转换成值
    //maxBy,minBy让流生成一个值，按照特定的顺序
    //eg:找出成员最多的乐队
    public Optional<Artist> mostMembers(Stream<Artist> artists){
        Function<Artist,Long> getCount = artist -> artist.getMemebers().stream().count();
        return artists.collect(maxBy(Comparator.comparing(getCount)));
    }

    //eg2:找出Albums中曲目的平均数
    public static double aveTracks(List<Album> albums){
        return albums.stream().collect(averagingInt(album -> album.getTracks().size()));
    }
    //5.3.3partitioningBy数据分块
    //eg：将艺术家分成独唱和乐队
    public static Map<Boolean,List<Artist>> bandAndSolo(Stream<Artist> artists){
        return artists.collect(partitioningBy(artist -> artist.isSolo()));
    }

    // 5.3.5s数据分组
    // 期望输出格式化好的艺术家列表，形如[ljl,yyh,dyh,cr]
    // 一般做法
    public static String listArtists(List<Artist> artists){
		StringBuilder sb = new StringBuilder("[");
		for (Artist artist: artists) {
			if(sb.length() > 1){
				sb.append(", ");
			}
			sb.append(artist.getName());
		}
		sb.append("]");
		return sb.toString();
	}

	//使用流和收集器来格式化
	//joining函数，以分割元素，前缀，后缀
	public static String listArtists2(List<Artist> artists){
		return artists.stream()
					   .map(Artist::getName)
				       .collect(joining(", ","[","]"));
	}

	// 5.3.6 使用组合收集器
	// 计算每个艺术家的专辑数，counting函数
	/**
	 *
	 * @param albums
	 * @return
	 */
	public static Map<Artist,Long> countAlbumNum(List<Album> albums){
		return albums.stream().collect(groupingBy(Album::getMainMusician,counting()));
	}

	// 计算每个艺术家的专辑名
	public static Map<Artist,List<String>> nameOfAlnumsDumb(List<Album> albums){
		return albums.stream().collect(groupingBy(Album::getMainMusician,mapping(
				Album::getName,toList()
		)));
	}


	// 5.3.7 重构和定制收集器
	// 定制收集器 实现上面的listArtists
	// 先使用reducec操作
	public static String listArtists3(List<Artist> artists){
		StringBuilder reduced = artists.stream()
										.map(artist -> artist.getName())
										.reduce(new StringBuilder(),(sb,name) -> {
											if (sb.length() > 1){
												sb.append(", ");
											}
											sb.append(name);
											return sb;
										},(left,right) -> left.append(right));
		reduced.insert(0,"[");
		reduced.append("]");
		return reduced.toString();
	}

	//使用自定义StringCombiner类
	public static String listArtists4(List<Artist> artists){
		StringCombiner result = artists.stream()
										.map(artist -> artist.getName())
										.reduce(new StringCombiner(", ", "[", "]"),
												StringCombiner::add,StringCombiner::merge);
		return  result.toString();
	}

	//使用自定义字符串收集器StringCollector收集字符串
	public static String listArtists5(List<Artist> artists){
		String result = artists.stream().map(Artist::getName)
										 .collect(new StringCollector(", ","[","]"));
		return result;
	}

	public static void main(String[] args) {
		//构建track
		Track track1 = new Track("曲目1", 50);
		Track track2 = new Track("曲目2", 60);
		Track track3 = new Track("曲目3", 61);
		Track track4 = new Track("曲目4", 62);
		List<Track> tracks1 = new ArrayList<>();
		List<Track> tracks2 = new ArrayList<>();
		List<Track> tracks3 = new ArrayList<>();
		tracks1.add(track1);
		tracks2.add(track1);
		tracks2.add(track2);
		tracks3.add(track1);
		tracks3.add(track2);
		tracks3.add(track3);
    	//构建artists
		Artist artist1 = new Artist("yyh1",new ArrayList<>(),"China");
		Artist artist2 = new Artist("yyh2",new ArrayList<>(),"China");
		List<Artist> members = new ArrayList<>();
		members.add(artist1);
		members.add(artist2);
		Artist artist3 = new Artist("yyh3",members,"China");
		Artist artist4 = new Artist("yyh4",new ArrayList<>(),"China");
		List<Artist> artists = new ArrayList<>();
		artists.add(artist3);
		artists.add(artist4);
		artists.add(artist1);
		//构建albums
		Album album1 = new Album("yyh1", tracks1, artists);album1.setMainmusicians(artist1);
		Album album2 = new Album("yyh2", tracks2, artists);album2.setMainmusicians(artist1);
		Album album3 = new Album("yyh3", tracks3, artists);album3.setMainmusicians(artist2);
		List<Album> albums = new ArrayList<>();
		albums.add(album1);
		albums.add(album2);
		albums.add(album3);
		String s = listArtists(artists);
		String s1 = listArtists2(artists);
		System.out.println(s);
		System.out.println(s1);
		//计算每个艺术家的专辑数
		Map<Artist, Long> artistLongMap = countAlbumNum(albums);
		//计算每个艺术家的专辑名
		Map<Artist, List<String>> artistListMap = nameOfAlnumsDumb(albums);
		//System.out.println(artistListMap);

		//用reduce操作重构listArtists3
		String s2 = listArtists3(artists);
		System.out.println(s2+"--3");

		//使用自定义StringCombiner类重构用reduce操作重构listArtists
		String s3 = listArtists4(artists);
		System.out.println(s3+"--4");

		//使用自定义字符串收集器StringCollector收集字符串
		String s4 = listArtists5(artists);
		System.out.println(s4+"--5");
	}
}
