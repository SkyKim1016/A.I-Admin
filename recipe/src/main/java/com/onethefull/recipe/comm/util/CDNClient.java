package com.onethefull.recipe.comm.util;

import java.io.IOException;
import java.io.InputStream;

public interface CDNClient {
	public String uploadImage(String bucketName, String objectKey, InputStream fileIn) throws IOException;
	public void init();
	public String uploadImage(String objectKey, InputStream fileIn) throws IOException;
	public void deleteObject(String bucketName, String objectKey);
	public void deleteObject(String objectKey);
	public void copyObject(String bucketName, String objectKey, String destinationBucketName, String destinationKey, boolean isProfile);
	public void copyObject(String key, String destinationKey);
	public String getObjectEtag(String objectKey);
	public long getObjectSize(String objectKey);
}