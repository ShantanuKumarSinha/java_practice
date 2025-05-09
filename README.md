@ExtendWith(MockitoExtension.class)
class APIServiceTest {

    @Mock
    private WebClient webClient;

    @Mock
    private JwtConstants jwtConstants;

    @Mock
    private Cp2aMasterDTO cp2aMasterDTO;

    @Mock
    private BaseWebClientService webClientService;

    @InjectMocks
    private APIService apiService;

    @BeforeEach
    void setup() {
        // Set private field values using reflection or setters (if available)
        ReflectionTestUtils.setField(apiService, "baseUrl", "https://mock-api.com/");
        ReflectionTestUtils.setField(apiService, "secretKey", "testSecret");
        ReflectionTestUtils.setField(apiService, "cp2aBatchBaseUrl", "https://batch-api.com/");
        ReflectionTestUtils.setField(apiService, "clientId", "testClientId");
        ReflectionTestUtils.setField(apiService, "clientSecret", "testClientSecret");
        ReflectionTestUtils.setField(apiService, "grantType", "client_credentials");
        ReflectionTestUtils.setField(apiService, "authV3TokenUrl", "https://auth.com/token");
        ReflectionTestUtils.setField(apiService, "executeLimit", 10);
    }

    @Test
    void testBuildPostAPIRequests() throws Exception {
        List<String> mockRequestList = List.of("request1");

        when(cp2aMasterDTO.getTenantId()).thenReturn("tenant1");
        when(cp2aMasterDTO.getUsername()).thenReturn("user1");

        // Mock static method
        try (MockedStatic<CubeUtils> cubeUtilsMockedStatic = Mockito.mockStatic(CubeUtils.class)) {
            cubeUtilsMockedStatic.when(() -> CubeUtils.generateJwtToken(any(), any(), any(), any()))
                                 .thenReturn("mockedToken");

            cubeUtilsMockedStatic.when(() -> CubeUtils.encryptTenant(any()))
                                 .thenReturn("encryptedTenant");

            ApiInputOutputRequestDTO<String, ?> result = apiService.buildPostAPIRequests(mockRequestList, "path");

            assertNotNull(result);
            assertEquals("https://mock-api.com/path", result.getHttpUrlComponent().getUrl());
        }
    }

    @Test
    void testDoDeleteAPI_withResponsePresent() throws Exception {
        Map<String, String> params = Map.of("key", "value");
        when(cp2aMasterDTO.getTenantId()).thenReturn("tenant1");
        when(cp2aMasterDTO.getUsername()).thenReturn("user1");

        try (MockedStatic<CubeUtils> cubeUtilsMockedStatic = Mockito.mockStatic(CubeUtils.class)) {
            cubeUtilsMockedStatic.when(() -> CubeUtils.generateJwtToken(any(), any(), any(), any()))
                                 .thenReturn("mockedToken");

            cubeUtilsMockedStatic.when(() -> CubeUtils.encryptTenant(any()))
                                 .thenReturn("encryptedTenant");

            when(webClientService.doDelete(anyString(), eq(String.class), any(), any()))
                .thenReturn(Optional.of("Success"));

            ApiResponseDTO<String> response = apiService.doDeleteAPI("delete-endpoint", params, String.class);
            assertTrue(response.getResponse().equals("Success"));
        }
    }

    // Add tests for buildCp2aBatchGetAPIRequest similarly...
}
