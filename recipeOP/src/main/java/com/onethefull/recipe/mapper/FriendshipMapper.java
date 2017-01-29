package com.onethefull.recipe.mapper;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.onethefull.recipe.comm.vo.PageInfoVO;
import com.onethefull.recipe.req.FriendshipReq;
import com.onethefull.recipe.vo.FriendVO;

@Repository("friendshipMapper")
public interface FriendshipMapper {

	public PageInfoVO getFriendsPageInfo(FriendshipReq req);
	public List<FriendVO> getFriends(FriendshipReq req);
	public int actFriendship(FriendshipReq req);

}
