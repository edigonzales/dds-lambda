package ch.so.agi.dds;

import javax.inject.Inject;
import javax.inject.Named;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import com.amazonaws.services.lambda.runtime.events.S3Event;
import com.amazonaws.services.lambda.runtime.events.models.s3.S3EventNotification;

@Named("test")
public class TestLambda implements RequestHandler<S3Event, String> {

    @Inject
    ProcessingService service;

    @Override
    public String handleRequest(S3Event event, Context context) {
        try {
            System.out.println(event.toString());
            S3EventNotification.S3EventNotificationRecord record = event.getRecords().get(0);
            //String srcBucket = record.getS3().getBucket().getName();
            //String srcKey = record.getS3().getObject().getUrlDecodedKey();

            //System.out.println(srcBucket + " " + srcKey);

            //AmazonS3 s3client = AmazonS3ClientBuilder.defaultClient();
            //S3Object s3object = s3client.getObject(record.getS3().getBucket().getName(), record.getS3().getObject().getUrlDecodedKey());
            //S3ObjectInputStream inputStream = s3object.getObjectContent();


            return "OK";

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
