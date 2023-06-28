package com.example.corejava8.stream.bean;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.Objects;

@NoArgsConstructor
@AllArgsConstructor
@ToString
public class ImageInfo {

    private Long imageId;

    private String imageName;

    private Integer size;

    private String context;


    @Override
    public int hashCode() {
        int result = 17;
        result = 31 * result + (imageId == null ? 0 : imageId.hashCode());
        result = 31 * result + (imageName == null ? 0 : imageName.hashCode());
        result = 31 * result + (context == null ? 0 : context.hashCode());
        return result;
    }


    @Override
    public boolean equals (Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        ImageInfo other = (ImageInfo) obj;
        return  Objects.equals(this.imageId, other.imageId) &&
                Objects.equals(this.imageName, other.imageName) &&
                Objects.equals(this.context, other.context);
    }
}
