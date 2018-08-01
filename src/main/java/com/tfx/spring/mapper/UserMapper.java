package com.tfx.spring.mapper;

import com.tfx.spring.beans.User;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface UserMapper {
	
	@Insert("insert into t_user(uname,upassword,uage,usex,uhiredate,updatedate) values(#{name},#{password},#{age},#{sex},#{hireDate},#{updateDate})")
	@Results({@Result(property = "name", column = "uname"),
				@Result(property = "password", column = "upassword"),
				@Result(property = "age", column = "uage"),
				@Result(property = "sex", column = "usex"),
				@Result(property = "hireDate", column = "uhiredate"),
				@Result(property="updateDate",column="updatedate")})
	public void add(User user);
	
	@Select("select * from t_user where uname=#{name} and upassword=#{password}")
	@Results({@Result(property = "name", column = "uname"),
		      @Result(property = "password", column = "upassword")})
	public User login(String name, String password);

	@SelectProvider(type = UserSelect.class, method = "findUsers")
	@Results({@Result(property = "name", column = "uname"),
		@Result(property = "password", column = "upassword"),
		@Result(property = "age", column = "uage"),
		@Result(property = "sex", column = "usex"),
		@Result(property = "hireDate", column = "uhiredate"),
		@Result(property="updateDate",column="updatedate")})
	public List<User> selectAll(@Param("datemin") java.sql.Date datemin, @Param("datemax") java.sql.Date datemax, @Param("sex") String sex, @Param("userMess") String userMess);
	
	@Select("select * from t_user where uname=#{name}")
	@Results({@Result(property = "name",column = "uname")})
	public User getUserName(String name);
	
	@Select("select * from t_user where id=#{id}")
	@Results({@Result(property = "name", column = "uname"),
		@Result(property = "password", column = "upassword"),
		@Result(property = "age", column = "uage"),
		@Result(property = "sex", column = "usex"),
		@Result(property = "hireDate", column = "uhiredate"),
		@Result(property="updateDate",column="updatedate")})
	public User getUserById(int id);
	
	@Update("update t_user set uname=#{name},upassword=#{password},uage=#{age},usex=#{sex},uhiredate=#{hireDate} where id=#{id}")
	@Results({@Result(property = "name", column = "uname"),
		@Result(property = "password", column = "upassword"),
		@Result(property = "age", column = "uage"),
		@Result(property = "sex", column = "usex"),
		@Result(property = "hireDate", column = "uhiredate"),
		@Result(property="updateDate",column="updatedate")})
	public void update(User u);
	
	@Delete("delete from t_user where id=#{id}")
	public void deleteUser(int id);
	
	
	class UserSelect{
		public String findUsers(@Param("datemin") java.sql.Date datemin,@Param("datemax") java.sql.Date datemax,@Param("sex") String sex,@Param("userMess") String userMess){
			String sql = "select * from t_user where 1=1 ";
			if(datemin!=null) {
				sql +="and uhiredate >=#{datemin} ";
			}
			if(datemax!=null) {
				sql +="and uhiredate <=#{datemax} ";
			}
			if(sex!=null && !sex.equals("")) {
				sql +="and usex = #{sex} ";
			}
			if(userMess!=null && !userMess.equals("")) {
				sql +="and uname like #{userMess}";
			}
			return sql;
		}
	}
}
