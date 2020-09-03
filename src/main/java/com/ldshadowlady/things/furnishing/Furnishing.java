package com.ldshadowlady.things.furnishing;

import com.google.common.base.Preconditions;

public final class Furnishing {
    private final String group;

    private final int red;

    private final int yellow;

    private final int blue;

    private Furnishing(Builder builder) {
        this.group = builder.group;
        this.red = builder.red;
        this.yellow = builder.yellow;
        this.blue = builder.blue;
    }

    public String getGroup() {
        return this.group;
    }

    public int getRed() {
        return this.red;
    }
    
    public int getYellow() {
        return this.yellow;
    }

    public int getBlue() {
        return this.blue;
    }

    public boolean hasDye() {
        return this.red > 0 || this.yellow > 0 || this.blue > 0;
    }

    public static final class Builder {
        private String group;

        private int red;

        private int yellow;

        private int blue;

        public Builder() {
            this.group = "";
            this.red = 0;
            this.yellow = 0;
            this.blue = 0;
        }

        public Builder group(String group) {
            Preconditions.checkNotNull(group, "group must not be null");
            this.group = group;
            return this;
        }

        public Builder red(int red) {
            Preconditions.checkArgument(red >= 0, "red must be greater than or equal to zero");
            this.red = red;
            return this;
        }

        public Builder yellow(int yellow) {
            Preconditions.checkArgument(yellow >= 0, "yellow must be greater than or equal to zero");
            this.yellow = yellow;
            return this;
        }

        public Builder blue(int blue) {
            Preconditions.checkArgument(blue >= 0, "blue be greater than or equal to zero");
            this.blue = blue;
            return this;
        }

        public Furnishing build() {
            return new Furnishing(this);
        }
    }
}
