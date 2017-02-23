package com.ironyard.data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * Created by rohanayub on 2/22/17.
 */
@Entity
public class BoardUser {
    @Id
    @GeneratedValue
    private long id;
    private String boardUsersName;
    private String boardDisplayName;
    private String boardPassword;
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getBoardUsersName() {
        return boardUsersName;
    }

    public void setBoardUsersName(String boardUsersName) {
        this.boardUsersName = boardUsersName;
    }

    public String getBoardDisplayName() {
        return boardDisplayName;
    }

    public void setBoardDisplayName(String boardDisplayName) {
        this.boardDisplayName = boardDisplayName;
    }

    public String getBoardPassword() {
        return boardPassword;
    }

    public void setBoardPassword(String boardPassword) {
        this.boardPassword = boardPassword;
    }


}
