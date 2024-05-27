package com.himedia.shop.controller;

import com.himedia.shop.controller.action.Action;
import com.himedia.shop.controller.action.IndexAction;
import com.himedia.shop.controller.action.admin.AdminAction;
import com.himedia.shop.controller.action.admin.AdminProductDetailAction;
import com.himedia.shop.controller.action.admin.AdminProductListAction;
import com.himedia.shop.controller.action.admin.AdminProductUpdateAction;
import com.himedia.shop.controller.action.admin.AdminProductUpdateFormAction;
import com.himedia.shop.controller.action.admin.AdminProductWriteAction;
import com.himedia.shop.controller.action.admin.AdminProductWriteFormAction;
import com.himedia.shop.controller.action.admin.AdminQnaDetailAction;
import com.himedia.shop.controller.action.admin.AdminQnaListAction;
import com.himedia.shop.controller.action.admin.AdminQnaReplyUpdateAction;
import com.himedia.shop.controller.action.admin.AdminloginAction;
import com.himedia.shop.controller.action.admin.AdminLogoutAction;
import com.himedia.shop.controller.action.admin.AdminMemberListAction;
import com.himedia.shop.controller.action.admin.AdminOrderListAction;
import com.himedia.shop.controller.action.admin.AdminOrderSaveAction;
import com.himedia.shop.controller.action.customer.QnaListAction;
import com.himedia.shop.controller.action.customer.QnaViewAction;
import com.himedia.shop.controller.action.customer.WriteQnaAction;
import com.himedia.shop.controller.action.customer.WriteQnaFormAction;
import com.himedia.shop.controller.action.member.ContractAction;
import com.himedia.shop.controller.action.member.FindZipnumAction;
import com.himedia.shop.controller.action.member.IdcheckFormAction;
import com.himedia.shop.controller.action.member.JoinAction;
import com.himedia.shop.controller.action.member.JoinFormAction;
import com.himedia.shop.controller.action.member.LoginAction;
import com.himedia.shop.controller.action.member.LoginFormAction;
import com.himedia.shop.controller.action.member.LogoutAction;
import com.himedia.shop.controller.action.mypage.CartDeleteAction;
import com.himedia.shop.controller.action.mypage.CartInsertAction;
import com.himedia.shop.controller.action.mypage.CartListAction;
import com.himedia.shop.controller.action.mypage.DeleteMemberAction;
import com.himedia.shop.controller.action.mypage.MypageAction;
import com.himedia.shop.controller.action.mypage.OrderAllAction;
import com.himedia.shop.controller.action.mypage.OrderDetailAction;
import com.himedia.shop.controller.action.mypage.OrderInsertAction;
import com.himedia.shop.controller.action.mypage.OrderInsertOneAction;
import com.himedia.shop.controller.action.mypage.OrderListAction;
import com.himedia.shop.controller.action.mypage.UpdateMemberAction;
import com.himedia.shop.controller.action.mypage.UpdateMemberFormAction;
import com.himedia.shop.controller.action.product.CategoryAction;
import com.himedia.shop.controller.action.product.ProductDetailAction;

public class ActionFactory {
	
	private ActionFactory() {}
	private static ActionFactory itc = new ActionFactory();
	public static ActionFactory getInstance() {return itc;}
	
	public Action getAction(String command) {
		Action ac = null;
		
		if(command.equals("index")) ac = new IndexAction();
		
		//member
		else if(command.equals("loginForm")) ac = new LoginFormAction();
		else if(command.equals("login")) ac = new LoginAction();
		else if(command.equals("logout")) ac = new LogoutAction(); 
		else if(command.equals("contract")) ac = new ContractAction();
		else if(command.equals("joinForm")) ac = new JoinFormAction();
		else if(command.equals("idcheckForm")) ac = new IdcheckFormAction();
		else if(command.equals("findZipnum")) ac = new FindZipnumAction();
		else if(command.equals("join")) ac = new JoinAction();
		
		//product
		else if(command.equals("category")) ac = new CategoryAction();
		else if(command.equals("productDetail")) ac = new ProductDetailAction();
		
		//mypage
		else if(command.equals("cartInsert")) ac = new CartInsertAction();
		else if(command.equals("cartList")) ac = new CartListAction();
		else if(command.equals("cartDelete")) ac = new CartDeleteAction();
		else if(command.equals("orderInsert")) ac = new OrderInsertAction();
		else if(command.equals("orderList")) ac = new OrderListAction();
		else if(command.equals("orderInsertOne")) ac = new OrderInsertOneAction();
		else if(command.equals("mypage")) ac = new MypageAction();
		else if(command.equals("orderAll")) ac = new OrderAllAction();
		else if(command.equals("updateMemberForm")) ac = new UpdateMemberFormAction();
		else if(command.equals("updateMember")) ac = new UpdateMemberAction();
		else if(command.equals("deleteMember")) ac = new DeleteMemberAction();
		else if(command.equals("orderDetail")) ac = new OrderDetailAction();
		
		//customer
		else if(command.equals("qnaList")) ac = new QnaListAction();
		else if(command.equals("qnaView")) ac = new QnaViewAction();
		else if(command.equals("writeQnaForm")) ac = new WriteQnaFormAction();
		else if(command.equals("writeQna")) ac = new WriteQnaAction();
		
		//admin
		else if(command.equals("admin")) ac = new AdminAction();
		else if(command.equals("adminlogin")) ac = new AdminloginAction();
		else if(command.equals("adminLogout")) ac = new AdminLogoutAction();
		else if(command.equals("adminProductList")) ac = new AdminProductListAction();
		else if(command.equals("adminProductDetail")) ac = new AdminProductDetailAction();
		else if(command.equals("adminProductWriteForm")) ac = new AdminProductWriteFormAction();
		else if(command.equals("adminProductWrite")) ac = new AdminProductWriteAction();
		else if(command.equals("adminProductUpdateForm")) ac = new AdminProductUpdateFormAction();
		else if(command.equals("adminProductUpdate")) ac = new AdminProductUpdateAction();
		else if(command.equals("adminOrderList")) ac = new AdminOrderListAction();
		else if(command.equals("adminOrderSave")) ac = new AdminOrderSaveAction();
		else if(command.equals("adminMemberList")) ac = new AdminMemberListAction();
		else if(command.equals("adminQnaList")) ac = new AdminQnaListAction();
		else if(command.equals("adminQnaDetail")) ac = new AdminQnaDetailAction();
		else if(command.equals("adminQnaReplyUpdate")) ac = new AdminQnaReplyUpdateAction();
		return ac;
	}
}
