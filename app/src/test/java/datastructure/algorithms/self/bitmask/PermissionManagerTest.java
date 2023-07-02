package datastructure.algorithms.self.bitmask;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class PermissionManagerTest {

    @Nested
    @DisplayName("권한_확인")
    class CheckPermission {
        @Test
        @DisplayName("어떤_권한도_없음")
        void test_permission_without_any_permission() {
            //given
            PermissionManager permissionManager = new PermissionManager(List.of(Permission.NONE));

            //when
            boolean hasReadUser = permissionManager.hasPermission(Permission.READ_USER);
            boolean hasWriteUser = permissionManager.hasPermission(Permission.WRITE_USER);
            String binaryString = permissionManager.toString();

            //then
            assertThat(hasReadUser).isFalse();
            assertThat(hasWriteUser).isFalse();
            assertThat(binaryString).isEqualTo("0");
        }

        @Test
        @DisplayName("사용자_읽기_권한만_있음")
        void test_permission_only_readUser() {
            //given
            PermissionManager permissionManager = new PermissionManager(List.of(Permission.READ_USER));

            //when
            boolean hasReadUser = permissionManager.hasPermission(Permission.READ_USER);
            boolean hasWriteUser = permissionManager.hasPermission(Permission.WRITE_USER);
            String binaryString = permissionManager.toString();

            //then
            assertThat(hasReadUser).isTrue();
            assertThat(hasWriteUser).isFalse();
            assertThat(binaryString).isEqualTo("1");
        }

        @Test
        @DisplayName("사용자_읽기_쓰기_권한_모두_존재")
        void test_permission_read_and_write_user() {
            //given
            PermissionManager permissionManager = new PermissionManager(List.of(Permission.READ_USER, Permission.WRITE_USER));

            //when
            boolean hasReadUser = permissionManager.hasPermission(Permission.READ_USER);
            boolean hasWriteUser = permissionManager.hasPermission(Permission.WRITE_USER);
            String binaryString = permissionManager.toString();

            //then
            assertThat(hasReadUser).isTrue();
            assertThat(hasWriteUser).isTrue();
            assertThat(binaryString).isEqualTo("11");
        }
    }


    @Nested
    @DisplayName("권한_추가")
    class GrantPermission {

        @Test
        @DisplayName("권한_없을때_사용자_읽기_권한_추가")
        void test_grantPermission_read_user_when_no_permission() {
            //given
            PermissionManager manager = new PermissionManager(List.of(Permission.NONE));

            //when
            String noPermissionBinaryString = manager.toString();
            manager.grantPermission(Permission.READ_USER);
            boolean hasReadUser = manager.hasPermission(Permission.READ_USER);
            String hasReadUserBinaryString = manager.toString();

            //then
            assertThat(noPermissionBinaryString).isEqualTo("0");
            assertThat(hasReadUser).isTrue();
            assertThat(hasReadUserBinaryString).isEqualTo("1");
        }

        @Test
        @DisplayName("사용자_읽기_권한_존재할때_사용자_쓰기_권한_추가")
        void test_grantPermission_write_user_when_having_read_user() {
            //given
            PermissionManager manager = new PermissionManager(List.of(Permission.READ_USER));

            //when
            String readUserBinaryString = manager.toString();
            manager.grantPermission(Permission.WRITE_USER);
            String readWriteUserBinaryString = manager.toString();
            boolean hasReadUser = manager.hasPermission(Permission.READ_USER);
            boolean hasWriteUser = manager.hasPermission(Permission.WRITE_USER);

            //then
            assertThat(readUserBinaryString).isEqualTo("1");
            assertThat(readWriteUserBinaryString).isEqualTo("11");
            assertThat(hasReadUser).isTrue();
            assertThat(hasWriteUser).isTrue();
        }
        @Test
        @DisplayName("자산_권한_추가")
        void test_grantPermission_asset() {
            //given
            PermissionManager manager = new PermissionManager(List.of(Permission.NONE));

            //when
            manager.grantPermission(Permission.READ_ASSET);
            String readAssetBinaryString = manager.toString();
            manager.grantPermission(Permission.READ_USER);
            String readUserReadAssetBinaryString = manager.toString();
            manager.grantPermission(Permission.WRITE_ASSET);
            String readUserReadWriteAssetBinaryString = manager.toString();

            //then
            assertThat(readAssetBinaryString).isEqualTo("100");
            assertThat(readUserReadAssetBinaryString).isEqualTo("101");
            assertThat(readUserReadWriteAssetBinaryString).isEqualTo("1101");
        }
    }

    @Nested
    @DisplayName("권한_회수")
    class RevokePermission {

        @Test
        @DisplayName("모든_권한_존재할때_권한회수")
        void test_revokePermission_when_having_full_permission() {
            //given
            PermissionManager manager = new PermissionManager(
                    List.of(
                            Permission.READ_USER,
                            Permission.WRITE_USER,
                            Permission.READ_ASSET,
                            Permission.WRITE_ASSET
                    )
            );

            //when
            manager.revokePermission(Permission.WRITE_USER);
            String revokeWriteUserBinaryString = manager.toString();
            manager.revokePermission(Permission.READ_ASSET);
            String revokeWURABinaryString = manager.toString();

            //then
            assertThat(revokeWriteUserBinaryString).isEqualTo("1101");
            assertThat(revokeWURABinaryString).isEqualTo("1001");
        }

        @Test
        @DisplayName("사용자_권한_존재할때_권한회수")
        void test_revokePermission_when_having_user_permission() {
            //given
            PermissionManager manager = new PermissionManager(List.of(Permission.READ_USER, Permission.WRITE_USER));

            //when
            manager.revokePermission(Permission.WRITE_USER);
            manager.revokePermission(Permission.READ_USER);
            String binaryString = manager.toString();

            //then
            assertThat(binaryString).isEqualTo("0");
        }
    }
}