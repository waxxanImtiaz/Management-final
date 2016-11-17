/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;


import javax.persistence.*;
//import org.hibernate.annotations.GenericGenerator;


@Entity  
@Table(name = "LoginInformation") 
public class LoginInformation {
    
    @Id 
    @GeneratedValue(strategy=GenerationType.AUTO)  
    private int id;
    
    @Column(name="username")
    private String username;
    
    @Column(name="PASSWORD")
    private String accept;
    
    @Column(name="PASSWORD")
    private String acceptLanguage;
    
    @Column(name="USERAGENT")
    private String userAgent;
    
    @Column(name="HOST")
    private String host;
    
    @Column(name="ACCEPTENCODING")
    private String acceptEncoding;
 
    @Column(name="CONNECTION")
    private String connection;
    
    @Column(name="CACHECONTROL")
    private String cacheControl;
    @Column(name="COOKIE")
    private String cookie;
    
     @Column(name="PASSWORD")
    private String password;

    @Column(name="date_time")
    private String date;
    /**
     * @return the id
     */

    public int getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * @return the username
     */
    public String getUsername() {
        return username;
    }

    /**
     * @param username the username to set
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * @return the accept
     */
    public String getAccept() {
        return accept;
    }

    /**
     * @param accept the accept to set
     */
    public void setAccept(String accept) {
        this.accept = accept;
    }

    /**
     * @return the acceptLanguage
     */
    public String getAcceptLanguage() {
        return acceptLanguage;
    }

    /**
     * @param acceptLanguage the acceptLanguage to set
     */
    public void setAcceptLanguage(String acceptLanguage) {
        this.acceptLanguage = acceptLanguage;
    }

    /**
     * @return the userAgent
     */
    public String getUserAgent() {
        return userAgent;
    }

    /**
     * @param userAgent the userAgent to set
     */
    public void setUserAgent(String userAgent) {
        this.userAgent = userAgent;
    }

    /**
     * @return the host
     */
    public String getHost() {
        return host;
    }

    /**
     * @param host the host to set
     */
    public void setHost(String host) {
        this.host = host;
    }

    /**
     * @return the acceptEncoding
     */
    public String getAcceptEncoding() {
        return acceptEncoding;
    }

    /**
     * @param acceptEncoding the acceptEncoding to set
     */
    public void setAcceptEncoding(String acceptEncoding) {
        this.acceptEncoding = acceptEncoding;
    }

    /**
     * @return the connection
     */
    public String getConnection() {
        return connection;
    }

    /**
     * @param connection the connection to set
     */
    public void setConnection(String connection) {
        this.connection = connection;
    }

    /**
     * @return the cacheControl
     */
    public String getCacheControl() {
        return cacheControl;
    }

    /**
     * @param cacheControl the cacheControl to set
     */
    public void setCacheControl(String cacheControl) {
        this.cacheControl = cacheControl;
    }
    /**
     * @return the cookie
     */
    public String getCookie() {
        return cookie;
    }

    /**
     * @param cookie the cookie to set
     */
    public void setCookie(String cookie) {
        this.cookie = cookie;
    }

    /**
     * @return the password
     */
    public String getPassword() {
        return password;
    }

    /**
     * @param password the password to set
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * @return the date
     */
    public String getDate() {
        return date;
    }

    /**
     * @param date the date to set
     */
    public void setDate(String date) {
        this.date = date;
    }
}
