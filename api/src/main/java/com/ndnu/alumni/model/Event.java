package com.ndnu.alumni.model;

public class Event
{
    private String id;
    private String title;
    private String type;
    private String organizer;
    private String major;
    private String topic;
    private String description;
    private long time;

    public Event(String id, String title, String type, String organizer, String major, String topic,
            String description, long time)
    {
        setId(id);
        setTitle(title);
        setType(type);
        setOrganizer(organizer);
        setMajor(major);
        setTopic(topic);
        setDescription(description);
        setTime(time);
    }

    public void setId(String id)
    {
        this.id = id;
    }

    public void setTitle(String title)
    {
        this.title = title;
    }

    public void setType(String type)
    {
        this.type = type;
    }

    public void setOrganizer(String organizer)
    {
        this.organizer = organizer;
    }

    public void setMajor(String major)
    {
        this.major = major;
    }

    public void setTopic(String topic)
    {
        this.topic = topic;
    }

    public void setDescription(String description)
    {
        this.description = description;
    }

    public void setTime(long time)
    {
        this.time = time;
    }

    // Getters
    public String getId()
    {
        return this.id;
    }

    public String getTitle()
    {
        return this.title;
    }

    public String getType()
    {
        return this.type;
    }

    public String getOrganizer()
    {
        return this.organizer;
    }

    public String getMajor()
    {
        return this.major;
    }

    public String getTopic()
    {
        return this.topic;
    }

    public String getDescription()
    {
        return this.description;
    }

    public long getTime()
    {
        return this.time;
    }
}
