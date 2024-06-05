package config;

public enum BaseResponseMessage {
    // 연결 관련(HTTP, 서버 등) 1000

    //-------------------- 회원기능 (일반 & 업체)
    // 일반 회원 관련 2000
    // 가입 성공
    USER_REGISTER_SUCCESS(true, 2000, "정상적으로 가입되었습니다."),
    // 이메일 2010
    // 이메일 인증 성공
    USER_EMAIL_AUTH_SUCCESS(true, 2010, "이메일 인증 성공"),
    // 이메일 입력 누락
    USER_REGISTER_FAIL_EMAIL_EMPTY(false, 2011, "이메일을 입력해주세요."),
    // 이메일 중복
    USER_REGISTER_FAIL_EMAIL_DUPLICATION(false, 2012, "중복되는 이메일입니다."),
    // 이메일 인증 실패
    USER_EMAIL_AUTH_FAIL(false, 2013, "이메일 인증 실패입니다."),


    // 비밀번호 2020
    // 비밀번호 규칙 안맞음
    USER_REGISTER_FAIL_PASSWORD_RULE(false, 2021, "비밀번호 규격이 맞지않습니다."),
    // 비밀번호 불일치
    USER_REGISTER_FAIL_PASSWORD_CHECK(false, 2022, "확인 비밀번호가 맞지않습니다."),
    // 비밀번호 미입력
    USER_REGISTER_FAIL_PASSWORD_EMPTY(false, 2023, "비밀번호를 입력해주세요."),

    // 이름 2030
    // 이상한 문자 입력
    USER_NAME_FAIL_RULE(false, 2031, "이름 규격이 맞지않습니다."),
    // 이름 미입력
    USER_NAME_FAIL_EMPTY(false, 2032, "이름을 입력해주세요."),


    // 생년월일 2040
    // 생년월일 미입력
    USER_BIRTH_FAIL_EMPTY(false, 2041, "생년월일을 입력해주세요."),
    // 이상한 문자 입력
    USER_BIRTH_FAIL_RULE(false, 2042, "생년월일 규격이 맞지않습니다."),
    // 성별 미체크
    USER_BIRTH_FAIL_SEX(false, 2043, "성별을 체크해주세요."),

    // 주소 2050
    // 주소 미입력
    USER_ADDRESS_FAIL_EMPTY(false, 2051, "주소를 입력해주세요."),

    // 연락처 2060
    // 휴대폰 인증 성공
    USER_PHONE_NUMBER_AUTH_SUCCESS(true, 2060, "휴대폰 인증 성공입니다."),
    // 휴대폰 인증 실패
    USER_PHONE_NUMBER_AUTH_FAIL(false, 2061, "휴대폰 인증 실패입니다."),
    // 휴대폰 번호 미입력
    USER_PHONE_NUMBER_FAIL_EMPTY(false, 2062, "휴대폰 번호를 입력해주세요."),
//-------------------------------------
    // 계좌번호 2070
    // 계좌 인증 성공
    USER_ACCOUNT_AUTH_SUCCESS(true, 2070, "계좌 인증 성공"),
    // 계좌 인증 실패
    USER_ACCOUNT_AUTH_FAIL(false, 2071, "계좌 인증 실패"),
    // 계좌번호 미입력
    USER_REGISTER_FAIL_ACCOUNT_EMPTY(false, 2072, "계좌번호를 입력해주세요."),


    // 사업자등록번호 2080
    // 사업자 인증 성공
    USER_BUSINESS_NUMBER_AUTH_SUCCESS(true, 2080, "사업자등록번호 인증 성공"),
    // 사업자 인증 실패
    USER_BUSINESS_NUMBER_AUTH_FAIL(false, 2081, "사업자등록번호 인증 실패"),
    // 사업자 미입력
    USER_REGISTER_FAIL_BUSINESS_NUMBER_FAIL_EMPTY(false, 2082, "사업자등록번호를 입력해주세요."),

    // 통신판매업신고번호 2090
    // 통신판매업신고번호 인증 성공
    USER_BUSINESS_IP_AUTH_SUCCESS(true, 2090, "통신판매업신고번호 인증 성공"),
    // 통신판매업신고번호 인증 실패
    USER_BUSINESS_IP_AUTH_FAIL(false, 2091, "통신판매업신고번호 인증 실패"),
    // 통신판매업신고번호 미입력
    USER_REGISTER_FAIL_BUSINESS_IP_EMPTY(false, 2092, "통신판매업신고번호를 입력해주세요."),




    // 로그인 2500
    // 로그인 성공
    USER_LOGIN_SUCCESS(true, 2500, "로그인 성공"),
    // 로그인 실패
    USER_LOGIN_FAIL(false, 2501, "로그인 실패"),
    // 없는 아이디
    USER_LOGIN_FAIL_EMAIL_NONE(false, 2502, "가입되지 않은 이메일입니다."),
    // 휴면 아이디
    USER_LOGIN_FAIL_EMAIL_SLEEP(false, 2503, "휴면 상태 이메일입니다."),
    // 비밀번호 불일치
    USER_LOGIN_FAIL_PASSWORD_DISCORD(false, 2504, "일치하지 않는 비밀번호입니다."),
    // 아이디 누락
    USER_LOGIN_FAIL_EMAIL_EMPTY(false, 2505, "아이디를 입력해주세요."),
    // 비밀번호 누락
    USER_LOGIN_FAIL_PASSWORD_EMPTY(false, 2506, "비밀번호를 입력해주세요."),




// -------------------------------------------------------
//-------------------- 업체기능
    // 업체정보 (업체명, 주소지, 판매업종, 업체소개) 3000
    // 업체 등록 성공
    COMPANY_REGIST_SUCCESS(true, 3000,"업체 등록에 성공했습니다."),
    // 업체 등록 실패
    COMPANY_REGIST_FAIL(false, 3001,"업체 등록에 실패했습니다."),
    // 업
    COMPANY_REGIST_FAIL_ADDR_EMPTY(false, 3002,"주소를 입력해주세요."),
    // 업체명 미입력
    COMPANY_REGIST_FAIL_NAME_EMPTY(false, 3003,"업체명을 입력해주세요."),
    // 업종 미입력
    COMPANY_REGIST_FAIL_TYPE_EMPTY(false, 3004,"업종을 입력해주세요."),
    // 소개글 미입력
    COMPANY_REGIST_FAIL_INTRO_EMPTY(false, 3005,"소개글을 입력해주세요."),

    // 상품정보 (회사인덱스, 상품명, 상품설명, 상품가격) 3100
    // 업체 등록 성공
    COMPANY_PRODUCT_REGIST_SUCCESS(true, 3100,"상품 등록에 성공했습니다."),
    // 업체 등록 실패
    COMPANY_PRODUCT_REGIST_FAIL(false, 3101,"상품 등록에 실패했습니다."),
    // 업
    COMPANY_PRODUCT_REGIST_FAIL_IDX_EMPTY(false, 3102,"주소를 입력해주세요."),
    // 업체명 미입력
    COMPANY_PRODUCT_REGIST_FAIL_NAME_EMPTY(false, 3103,"업체명을 입력해주세요."),
    // 업종 미입력
    COMPANY_PRODUCT_REGIST_FAIL_TYPE_EMPTY(false, 3104,"업종을 입력해주세요."),
    // 소개글 미입력
    COMPANY_PRODUCT_REGIST_FAIL_INTRO_EMPTY(false, 3105,"소개글을 입력해주세요."),

//-------------------- 공구기능
    // 공구 관련
    // 공구 등록 4000
    // 공구 등록 성공
    GROUPBUY_REGIST_SUCCESS(true, 4000, "공구 등록이 완료되었습니다."),
    // 공구 등록 실패
    GROUPBUY_RREGIST_FAIL(false,4001,"공구 등록에 실패하였습니다."),
    // 공구 카테고리,
    GROUPBUY_RREGIST_FAIL_CATEGORY_EMPTY(false,4002,"공구 카테고리를 선택하지 않았습니다."),
    // 공구 제목,
    GROUPBUY_RREGIST_FAIL_TITLE_EMPTY(false,4003, "공구 제목을 입력하지 않았습니다."),
    // 공구 수량,
    GROUPBUY_RREGIST_FAIL_QUANTITY_EMPTY(false,4004,"공구 수량을 입력하지 않았습니다."),
    // 공구 내용,
    GROUPBUY_RREGIST_FAIL_CONTENT_EMPTY(false,4005,"공구 내용을 입력하지 않았습니다."),
    // 공구 기간,
    GROUPBUY_RREGIST_FAIL_PERIOD_EMPTY(false,4006,"공구 기간을 입력하지 않았습니다."),

    // 공구 시작 4100,
    // 시작 성공
    GROUPBUY_START_SUCCESS(true,4100,"공구가 시작되었습니다."),
    // 시작 실패,
    GROUPBUY_START_FAIL(false,4101,"공구 시작에 실패하였습니다."),
    // 입찰 지원자 없음,
    GROUPBUY_START_FAIL_NO_APPLICANT(false,4102,"입찰 지원자가 없습니다."),
    // 입찰자 미선정,
    GROUPBUY_START_FAIL_NOT_SELECTED(false,4103,"입찰자가 미선정 되었습니다."),
// -------------------------------------------------------

    // 공구 모집 4200
    // 공구 모집 완료
    GROUPBY_RECRUITING_SUCCESS(true,4200,"공구 모집이 완료되었습니다."),
    // 공구 모집 실패
    GROUPBY_RECRUITING_FAIL(false,4201,"공구 모집에 실패 했습니다."),
    // 모집 기간 만료(모집 인원 미달)
    GROUPBY_RECRUITING_FAIL_DEADLINE(false,4202,"공구 모집 기간이 만료되었습니다."),
    // 판매 불가로 인한 실패
    GROUPBY_RECRUITING_FAIL_IMPOSSIBLE_SELL(false,4203,"판매자 사정으로 공구가 중단되었습니다."),

    // 공구 참가 4300
    // 공구 참가 성공
    GROUPBUY_JOIN_SUCCESS(true,4300,"공구 참가에 성공했습니다."),
    // 공구 참가 실패
    GROUPBUY_JOIN_FAIL(false,4301,"공구 참가에 실패했습니다."),
    // 공구 수량 초과
    GROUPBUY_JOIN_FAIL_QUANTITY_OVER(false,4302,"공구 목표 수량이 초과되었습니다."),
    // 등록된 결제 수단이 없음
    GROUPBUY_JOIN_FAIL_PAYMENT_EMPTY(false,4303,"등록된 결제 수단이 없습니다."),
    // 구매 개수 미입력
    GROUPBUY_JOIN_FAIL_QUANTITY_EMPTY(false,4304,"구매 개수가 입력되지 않았습니다."),

    // 배송지 미입력
    GROUPBUY_JOIN_FAIL_ADDRESS_EMPTY(false,4305,"배송지가 입력되지 않았습니다."),

    // 공구 조회 4400
    // 공구 조회 성공
    GROUPBUY_LIST_SUCCESS(true,4300,"공구 조회에 성공했습니다."),
    // 공구 조회 실패
    GROUPBUY_LIST_FAIL(false,4301,"공구 조회에 실패했습니다."),

//-------------------- 입찰기능
    // 입찰 관련 5000

    // 입찰 등록 5000
    // 등록 성공,
    BID_REGIST_SUCCESS(true,5000,"입찰 등록에 성공하였습니다."),
    // 등록 실패,
    BID_REGIST_FAIL(false,5001,"입찰 등록에 실패하였습니다."),
    // 상품 미입력,
    BID_REGIST_PRODUCT_EMPTY(false,5002,"상품을 선택하지 않았습니다."),
    // 가격 미입력,
    BID_REGIST_PRICE_EMPTY(false,5003,"가격을 입력하지 않았습니다."),

    // 입찰 조회 5100
    BID_LIST_SUCCESS(true,5100,"입찰 조회에 성공하였습니다."),

    BID_LIST_FAIL(false,5101,"입찰 조회에 실패하였습니다."),

    // 입찰 취소 5200
    BID_DELETE_SUCCESS(true,5200,"입찰 취소에 성공하였습니다."),

    BID_DELETE_FAIL(false,5201,"입찰 취소에 실패하였습니다."),

    // 입찰 선정 5300
    BID_SELECT_SUCCESS(true,5300,"입찰 선정에 성공하였습니다."),

    BID_SELECT_FAIL(false,5301,"입찰 선정에 실패하였습니다."),



    ;
    // 결제 관련 6000
    // 게시판 관련 7000


    private Boolean isSuccess;
    private Integer code;
    private String message;

    BaseResponseMessage(Boolean isSuccess, Integer code, String message) {
        this.isSuccess = isSuccess;
        this.code = code;
        this.message = message;
    }

    public Boolean getSuccess() {
        return isSuccess;
    }

    public Integer getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }
}