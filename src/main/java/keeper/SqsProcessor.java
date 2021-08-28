package keeper;

import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.auth.BasicSessionCredentials;
import com.amazonaws.auth.profile.ProfileCredentialsProvider;
import com.amazonaws.services.securitytoken.AWSSecurityTokenService;
import com.amazonaws.services.securitytoken.AWSSecurityTokenServiceClientBuilder;
import com.amazonaws.services.securitytoken.model.AssumeRoleRequest;
import com.amazonaws.services.securitytoken.model.AssumeRoleResult;
import com.amazonaws.services.securitytoken.model.Credentials;
import com.amazonaws.services.sqs.AmazonSQS;
import com.amazonaws.services.sqs.AmazonSQSClient;
import com.amazonaws.services.sqs.AmazonSQSClientBuilder;
import com.amazonaws.services.sqs.model.SendMessageRequest;


public class SqsProcessor {

    public static void main(String [] args) {
        AmazonSQS sqs = getKeeperDevSQSClient();
        // AmazonSQS sqs = getPersonalSQSClient();

        SendMessageRequest send_msg_request = new SendMessageRequest()
                .withQueueUrl("https://sqs.us-east-1.amazonaws.com/274993841888/dev-third-party-integration-process-braze.fifo")
                // .withQueueUrl("https://sqs.us-east-1.amazonaws.com/070337285578/test.fifo")
                .withMessageBody("    {\n" +
                        "      \"name\": \"web_user_purchase\",\n" +
                        "      \"user_id\": \"test_user\",\n" +
                        "      \"time\": \"2021-01-08T19:20:30+01:00\"\n" +
                        "    }")
                .withMessageGroupId("test")
                .withMessageDeduplicationId("test");
        sqs.sendMessage(send_msg_request);
    }

    private static AmazonSQS getPersonalSQSClient() {
        return new AmazonSQSClient(new BasicAWSCredentials("AKIAJ5SOBCWWZW6CWNGA", "492FuHFCghbYga9zzRyAJRPJ3ffvKcHW9axCVXFR"));
    }


    private static AmazonSQS getKeeperDevSQSClient() {
        AWSSecurityTokenService stsClient = AWSSecurityTokenServiceClientBuilder.standard()
                .withCredentials(new ProfileCredentialsProvider())
                .withRegion("us-east-1")
                .build();

        AssumeRoleRequest roleRequest = new AssumeRoleRequest()
                .withRoleArn("arn:aws:iam::274993841888:role/dev_bizdev_access")
                .withRoleSessionName("dev_bizdev_access");
        AssumeRoleResult roleResponse = stsClient.assumeRole(roleRequest);
        Credentials sessionCredentials = roleResponse.getCredentials();

        BasicSessionCredentials awsCredentials = new BasicSessionCredentials(
                sessionCredentials.getAccessKeyId(),
                sessionCredentials.getSecretAccessKey(),
                sessionCredentials.getSessionToken());

        AmazonSQS sqs = AmazonSQSClientBuilder.standard()
                .withCredentials(new AWSStaticCredentialsProvider(awsCredentials))
                .withRegion("us-east-1")
                .build();

        return sqs;
    }
}