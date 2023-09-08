import com.example.springdbproejct.dtos.UserDTO;
import com.example.springdbproejct.mappers.DateMapper;
import com.example.springdbproejct.mappers.RoomMapper;
import com.example.springdbproejct.mappers.StdMapper;
import com.example.springdbproejct.mappers.UserMapper;
import lombok.extern.log4j.Log4j2;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@Log4j2
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:config/servlet-context.xml")
public class MySpringTest {
    @Autowired
    DateMapper dateMapper;

    @Autowired
    UserMapper userMapper;

    @Autowired
    RoomMapper roomMapper;

    @Autowired
    StdMapper stdMapper;

    @Test
    public void board_user_test() {
        // System.out.println(userMapper.get_user("korea", 123));
    }

    @Test
    public void user_test() {
        /*** INSERT ***/
        // insert(1)
        // boolean insert_result = userMapper.insert_user("tai", "123", "타이");
        // System.out.println(insert_result);

        // insert(2)
        // UserDTO내의 인스턴스 값들을 바로 DB Value값에 맞춰서 넣어줌~
        // UserDTO insertDto = new UserDTO("north-america", "221", "북아메리카", LocalDate.now());
        // System.out.println(userMapper.insert_user(insertDto)); // true

        /*** SELECT ***/
        // select(1) get_user()
        // UserDTO selectDto = userMapper.get_user("japan");
        // System.out.println(selectDto);

        // select(2) get_users()
        // System.out.println(userMapper.get_users());

        // select(3)
        // System.out.println(userMapper.get_users_of_capacity((byte) 5));

        //user의 id만을 전달하여 메소들을 호출하고, 해당 user 정보 출력 (내부에 있는 room 데이터까지 모두 출력)
        // UserDTO user1 = userMapper.get_user_by_id("america");
        // System.out.println(user1.getId() + user1.getNickname() + user1.getRoomNo() + user1.getRegosterDate());
    }

    @Test
    public void room_test() {
        // log.info("test");
        //        RoomDTO roomDTO = new RoomDTO((byte) 1, (byte) 10);
//        roomMapper.create_room(roomDTO);
//        roomDTO = new RoomDTO((byte) 2, (byte) 2);
//        roomMapper.create_room(roomDTO);
//        roomDTO = new RoomDTO((byte) 3, (byte) 4);
//        roomMapper.create_room(roomDTO);
//        roomDTO = new RoomDTO((byte) 4, (byte) 3);
//        roomMapper.create_room(roomDTO);

//        List<RoomDTO> roomDTOList = Arrays.asList(
//                new RoomDTO((byte) 5, (byte) 12),
//                new RoomDTO((byte) 6, (byte) 14)
//        );
//        roomMapper.create_rooms(roomDTOList);
          // log.info(roomMapper.get_rooms(2));
    }

    @Test
    public void std_club_test() {
        // System.out.println(stdMapper.get_std());
        // System.out.println(stdMapper.get_info());
    }

    @Test
    public void main_test() {
        // System.out.println(dateMapper.select_now());
        // System.out.println(dateMapper.select_now2());
        // System.out.println("excuted.");
    }
}

