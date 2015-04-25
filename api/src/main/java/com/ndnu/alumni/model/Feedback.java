package com.ndnu.alumni.model;

public class Feedback
{
    private String id;
    private String userId;
    private String response1;
    private String response2;
    private String response3;
    private String response4;
    private String response5;

    public Feedback(String id, String userId, String response1, String response2, String response3,
            String response4, String response5)
    {
        setId(id);
        setUserId(userId);
        setResponse1(response1);
        setResponse2(response2);
        setResponse3(response3);
        setResponse4(response4);
        setResponse5(response5);
    }

    public void setId(String id)
    {
        this.id = id;
    }

    public void setUserId(String userId)
    {
        this.userId = userId;
    }

    public void setResponse1(String response1)
    {
        this.response1 = response1;
    }

    public void setResponse2(String response2)
    {
        this.response2 = response2;
    }

    public void setResponse3(String response3)
    {
        this.response3 = response3;
    }

    public void setResponse4(String response4)
    {
        this.response4 = response4;
    }

    public void setResponse5(String response5)
    {
        this.response5 = response5;
    }

    // Getters
    public String getId()
    {
        return this.id;
    }

    public String getUserId()
    {
        return this.userId;
    }

    public String getResponse1()
    {
        return this.response1;
    }

    public String getResponse2()
    {
        return this.response2;
    }

    public String getResponse3()
    {
        return this.response3;
    }

    public String getResponse4()
    {
        return this.response4;
    }

    public String getResponse5()
    {
        return this.response5;
    }
}
