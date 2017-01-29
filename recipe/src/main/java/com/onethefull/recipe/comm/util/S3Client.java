package com.onethefull.recipe.comm.util;

import java.io.IOException;
import java.io.InputStream;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import com.onethefull.recipe.type.CDNRegionType;

@Component
public class S3Client {
	private CDNClient cdnClient;
	@Value("#{serverProperty['region.type']}")
	private String regionType;
	@Value("#{serverProperty['cdn.bucket']}")
	private String bucketName;
	
	@PostConstruct
	public void init() {
		regionType = regionType.toUpperCase();
		if(regionType.equals(CDNRegionType.AWS.name())) {
			cdnClient = new AWSCDNClient();
		} else {
			System.err.print(regionType+" is not found");
			System.exit(0);
		}
		cdnClient.init();
	}

	public String uploadImage(String bucketName, String objectKey, InputStream fileIn) throws IOException {
		return cdnClient.uploadImage(bucketName, objectKey, fileIn);
	}

	public String uploadImage(String objectKey, InputStream fileIn) throws IOException {
		return cdnClient.uploadImage(bucketName, objectKey, fileIn);
	}

	public void deleteObject(String bucketName, String objectKey) {
		cdnClient.deleteObject(bucketName, objectKey);
	}

	public void deleteObject(String objectKey) {
		cdnClient.deleteObject(null, objectKey);
	}

	public void copyObject(String bucketName, String objectKey, String destinationBucketName, String destinationKey, boolean isProfile) {
		cdnClient.copyObject(bucketName, objectKey, destinationBucketName, destinationKey, isProfile);
	}

	public void copyObject(String key, String destinationKey) {
		cdnClient.copyObject(key, destinationKey);
	}

	public String getObjectEtag(String objectKey) {
		return cdnClient.getObjectEtag(objectKey);
	}

	public long getObjectSize(String objectKey) {
		return cdnClient.getObjectSize(objectKey);
	}
}