package com.onethefull.recipe.service;

import java.io.File;
import java.io.IOException;

import net.coobird.thumbnailator.Thumbnails;

public class ImageTest {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		Thumbnails.of(new File("/users/kimsungjun/Documents/222.jpg"))
        .scale(0.05f, 0.05f)
        .toFile(new File("/users/kimsungjun/Documents/thumbnail.jpg"));
	}

}
