package com.example.playvideos.model;

import java.io.Serializable;

public class PlayVideosObj implements Serializable {
        private String thumb;

        private String description;

        private String id;

        private String title;

        private String url;

        public String getThumb ()
        {
            return thumb;
        }

        public void setThumb (String thumb)
        {
            this.thumb = thumb;
        }

        public String getDescription ()
        {
            return description;
        }

        public void setDescription (String description)
        {
            this.description = description;
        }

        public String getId ()
        {
            return id;
        }

        public void setId (String id)
        {
            this.id = id;
        }

        public String getTitle ()
        {
            return title;
        }

        public void setTitle (String title)
        {
            this.title = title;
        }

        public String getUrl ()
        {
            return url;
        }

        public void setUrl (String url)
        {
            this.url = url;
        }

        @Override
        public String toString()
        {
            return "ClassPojo [thumb = "+thumb+", description = "+description+", id = "+id+", title = "+title+", url = "+url+"]";
        }
}


