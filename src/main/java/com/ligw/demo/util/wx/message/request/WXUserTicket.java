package com.ligw.demo.util.wx.message.request;

import com.ligw.demo.util.wx.message.BaseMessage;

/**
 * Description: 成员票据
 * Author: qinweitao
 * CopyRight: bhne
 * Create Date: 2017-09-04
 */
public class WXUserTicket extends BaseMessage {
    /* {
         "user_ticket": "USER_TICKET"
      }*/
    private String user_ticket;

    public void setUser_ticket(String user_ticket) {
        this.user_ticket = user_ticket;
    }

    public String getUser_ticket() {
        return user_ticket;
    }
}
