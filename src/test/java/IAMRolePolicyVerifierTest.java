import org.junit.jupiter.api.Test;
import iam.role.policy.verifier.IAMRolePolicyVerifier;

import static org.junit.jupiter.api.Assertions.*;
public class IAMRolePolicyVerifierTest {
    @Test
    void testVerifyIAMRolePolicy_ValidPolicy() {
        String jsonFile = "src/test/resources/valid_policy.json";
        assertTrue(IAMRolePolicyVerifier.verifyRolePolicy(jsonFile));
    }

    @Test
    void testVerifyIAMRolePolicy_InvalidPolicy() {
        String inputJsonFile = "src/test/resources/invalid_policy.json";
        assertFalse(IAMRolePolicyVerifier.verifyRolePolicy(inputJsonFile));
    }

    @Test
    void testVerifyIAMRolePolicy_EmptyPolicy() {
        String inputJsonFile = "src/test/resources/empty_policy.json";
        assertTrue(IAMRolePolicyVerifier.verifyRolePolicy(inputJsonFile));
    }

    @Test
    void testVerifyIAMRolePolicy_TwoAsterisksPolicy() {
        String inputJsonFile = "src/test/resources/two_asterisks_policy.json";
        assertTrue(IAMRolePolicyVerifier.verifyRolePolicy(inputJsonFile));
    }

    @Test
    void testVerifyIAMRolePolicy_EmptyFile() {
        String inputJsonFile = "src/test/resources/empty_file.json";
        assertFalse(IAMRolePolicyVerifier.verifyRolePolicy(inputJsonFile));
    }

    @Test
    void testVerifyIAMRolePolicy_MissingResourceField() {
        String inputJsonFile = "src/test/resources/missing_resource_field.json";
        assertFalse(IAMRolePolicyVerifier.verifyRolePolicy(inputJsonFile));
    }
}
