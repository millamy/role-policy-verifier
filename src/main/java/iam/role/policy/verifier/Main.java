package iam.role.policy.verifier;

import static iam.role.policy.verifier.IAMRolePolicyVerifier.verifyRolePolicy;

public class Main {

    public static void main(String[] args) {
        String inputJsonFile = "src/main/resources/input.json";
        boolean result = verifyRolePolicy(inputJsonFile);
        System.out.println(result);
    }
}