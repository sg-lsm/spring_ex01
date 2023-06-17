package Todo.service;

import Todo.dao.MemberDAO;
import Todo.domain.MemberVO;
import Todo.dto.MemberDTO;
import Todo.util.MapperUtil;
import lombok.extern.log4j.Log4j2;
import org.modelmapper.ModelMapper;

@Log4j2
public enum MemberService {
    INSTANCE;

    private MemberDAO dao;
    private ModelMapper mapper;

    MemberService(){
        dao = new MemberDAO();
        mapper = MapperUtil.INSTANCE.get();
    }
    public MemberDTO login(String mid, String mpw) throws Exception{
        MemberVO vo = dao.getWithPassword(mid, mpw);
        MemberDTO memberDTO = mapper.map(vo, MemberDTO.class);
        return memberDTO;
    }
    public void updateUuid(String mid, String uuid) throws Exception{
        dao.updateUuid(mid, uuid);
    }

    public MemberDTO getByUUID(String uuid) throws Exception{
        MemberVO vo = dao.selectUuid(uuid);
        MemberDTO dto = mapper.map(vo, MemberDTO.class);
        return dto;
    }
}
