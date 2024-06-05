// 서버가 모든 요청의 처리를 다 하고 클라이언트에게 응답을 보낼 때 응답값을 리스폰스에 담아서
// 보낸다. 이 리스폰스 객체를 서블릿으로 보내서 json으로 매핑하고 클라이언트로 보낸다.

package user.response;

public class PostMemberLoginRes {
    Integer idx;
    String id;
    String name;

    public PostMemberLoginRes(Integer idx, String id, String name) {
        this.idx = idx;
        this.id = id;
        this.name = name;
    }

    public Integer getIdx() { return idx; }

    public void setIdx(Integer idx) { this.idx = idx; }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() { return name; }

    public void setName(String name) { this.name = name; }
}
