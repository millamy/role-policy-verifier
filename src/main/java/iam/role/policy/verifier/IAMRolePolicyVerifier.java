package iam.role.policy.verifier;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class IAMRolePolicyVerifier {
    public static boolean verifyRolePolicy(String jsonFile) {
        try {
            String fileContent = new String(Files.readAllBytes(Paths.get(jsonFile)));

            if (fileContent.trim().isEmpty()) {
                System.out.println("File is empty.");
                return false;
            }

            JSONParser parser = new JSONParser();
            Object obj = parser.parse(fileContent);
            JSONObject jsonObject = (JSONObject) obj;

            JSONObject policyDocument = (JSONObject) jsonObject.get("PolicyDocument");
            JSONArray statements = (JSONArray) policyDocument.get("Statement");

            for (Object statementObj : statements) {
                JSONObject statement = (JSONObject) statementObj;
                if (!statement.containsKey("Resource") || statement.get("Resource") == null) {
                    System.out.println("Missing Resource field.");
                    return false;
                }
                String resource = (String) statement.get("Resource");
                if (resource != null && resource.equals("*")) {
                    return false;
                }
            }

            return true;
        } catch (IOException | ParseException e) {
            e.printStackTrace();
            return false;
        }
    }
}
