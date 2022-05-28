import java.util.Arrays;

public class Contact {

    private final byte MAX_EMAILS = 3;
    private final byte MAX_SOCIALS = 5;

    private Email[] emails;
    private Social[] socials;
    private ContactInfo phoneNumber;

    private String contactName;

    private class NameContactInfo implements ContactInfo{
        @Override
        public String getTitle() {return "Name";}
        @Override
        public String getValue() {return contactName;}

    }
    public static class Email implements ContactInfo {
        private String email;
        public Email(String localPart, String domain){email = localPart + "@" + domain;}
        @Override
        public String getTitle() {
            return "Email";
        }
        @Override
        public String getValue() {return email;}
    }

    public static class Social implements ContactInfo{
        private String classValue;
        private String classTitle;
        @Override
        public String getTitle() {
            return classTitle;
        }

        @Override
        public String getValue() {
            return classValue;
        }
    }

    public Contact(String contactName) {
        //Implement this method
        if(contactName != null){
            this.contactName = contactName;
            this.emails = new Email[0];
            this.socials = new Social[0];
            this.phoneNumber = null;
        }
    }

    public void rename(String newName) {
        //Implement this method
        if (newName != null && !newName.equals("")){
            this.contactName = newName;
        }
    }



    public Email addEmail(String localPart, String domain) {
        //Implement this method
        if (emails.length < MAX_EMAILS){
            emails = Arrays.copyOf(emails, emails.length + 1);
            return emails[emails.length - 1] = new Email(localPart, domain);
        }else {
            return null;
        }
    }


    public Email addEpamEmail(String firstname, String lastname) {
        //Implement this method
        if (emails.length < MAX_EMAILS) {
            emails = Arrays.copyOf(emails, emails.length + 1);
            return emails[emails.length - 1] = new Email(firstname, lastname) {
                @Override
                public String getTitle() {return "Epam Email";}
                @Override
                public String getValue() {return firstname + "_" + lastname + "@epam.com";}
            };
        }else return null;



    }

    public ContactInfo addPhoneNumber(int code, String number) {
        //Implement this method
        if (phoneNumber == null){
            return this.phoneNumber = new ContactInfo() {
                @Override
                public String getTitle() {
                    return "Tel";
                }

                @Override
                public String getValue() {
                    return "+" + code + " " + number;
                }
            };
        }else return null;

    }

    public Social addTwitter(String twitterId) {
        //Implement this method
        if(socials.length < MAX_SOCIALS) {
            socials = Arrays.copyOf(socials, socials.length + 1);
            return socials[socials.length - 1] = new Social() {
                @Override
                public String getTitle() {
                    return "Twitter";
                }

                @Override
                public String getValue() {
                    return twitterId;
                }
            };
        } else {
            return null;
        }

    }

    public Social addInstagram(String instagramId) {
        //Implement this method
        if(socials.length < MAX_SOCIALS) {
            socials = Arrays.copyOf(socials, socials.length + 1);
            return socials[socials.length - 1] = new Social() {
                @Override
                public String getTitle() {
                    return "Instagram";
                }

                @Override
                public String getValue() {
                    return instagramId;
                }
            };
        } else {
            return null;
        }
    }

    public Social addSocialMedia(String title, String id) {
        //Implement this method
        if(socials.length < MAX_SOCIALS) {
            socials = Arrays.copyOf(socials, socials.length + 1);
            return socials[socials.length - 1] = new Social() {
                @Override
                public String getTitle() {
                    return title;
                }

                @Override
                public String getValue() {
                    return id;
                }
            };
        } else {
            return null;
        }
    }

    public ContactInfo[] getInfo() {
        //Implement this method
        int lastPos = 1;

        int arrLength = 1 + emails.length + socials.length;

        if (phoneNumber != null) {
            ++arrLength;
        }

        ContactInfo[] arr = new ContactInfo[arrLength];
        arr[0] = new NameContactInfo();
        if (phoneNumber != null) {
            arr[1] = phoneNumber;
            lastPos = 2;
        }
        System.arraycopy(emails, 0, arr, lastPos, emails.length);
        lastPos += emails.length;
        System.arraycopy(socials, 0, arr, lastPos, socials.length);
        return arr;
    }

}
