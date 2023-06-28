package com.example.corejava8.stream;

import com.example.corejava8.stream.bean.ImageInfo;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamDistinct {

    public static void main(String[] args) {
        ImageInfo imageInfo = new ImageInfo(99L, "知行合一", 12,"王阳明心学精髓之一");
        ImageInfo imageInfo2 = new ImageInfo(99L, "知行合一", 14,"王阳明心学精髓之一");
        List<ImageInfo> infoList = Stream.of(imageInfo, imageInfo2).distinct().collect(Collectors.toList());
        infoList.forEach(System.out::println);
    }
}
