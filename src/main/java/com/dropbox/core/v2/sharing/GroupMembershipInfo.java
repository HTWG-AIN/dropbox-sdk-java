/* DO NOT EDIT */
/* This file was generated from sharing_folders.babel */

package com.dropbox.core.v2.sharing;

import com.dropbox.core.json.JsonArrayReader;
import com.dropbox.core.json.JsonReadException;
import com.dropbox.core.json.JsonReader;
import com.dropbox.core.json.JsonWriter;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;

import java.io.IOException;
import java.util.List;

/**
 * The information about a group member of the shared folder.
 */
public class GroupMembershipInfo extends MembershipInfo {
    // struct GroupMembershipInfo

    private final GroupInfo group;

    /**
     * The information about a group member of the shared folder.
     *
     * <p> Use {@link newBuilder} to create instances of this class without
     * specifying values for all optional fields. </p>
     *
     * @param accessType  The access type for this member. Must not be {@code
     *     null}.
     * @param group  The information about the membership group. Must not be
     *     {@code null}.
     * @param permissions  The permissions that requesting user has on this
     *     member. The set of permissions corresponds to the MemberActions in
     *     the request. Must not contain a {@code null} item.
     * @param initials  Suggested name initials for a member.
     * @param isInherited  True if the member's access to the file is inherited
     *     from a parent folder.
     *
     * @throws IllegalArgumentException  If any argument does not meet its
     *     preconditions.
     */
    public GroupMembershipInfo(AccessLevel accessType, GroupInfo group, List<MemberPermission> permissions, String initials, boolean isInherited) {
        super(accessType, permissions, initials, isInherited);
        if (group == null) {
            throw new IllegalArgumentException("Required value for 'group' is null");
        }
        this.group = group;
    }

    /**
     * The information about a group member of the shared folder.
     *
     * <p> The default values for unset fields will be used. </p>
     *
     * @param accessType  The access type for this member. Must not be {@code
     *     null}.
     * @param group  The information about the membership group. Must not be
     *     {@code null}.
     *
     * @throws IllegalArgumentException  If any argument does not meet its
     *     preconditions.
     */
    public GroupMembershipInfo(AccessLevel accessType, GroupInfo group) {
        this(accessType, group, null, null, false);
    }

    /**
     * The information about the membership group.
     *
     * @return value for this field, never {@code null}.
     */
    public GroupInfo getGroup() {
        return group;
    }

    /**
     * Returns a new builder for creating an instance of this class.
     *
     * @param accessType  The access type for this member. Must not be {@code
     *     null}.
     * @param group  The information about the membership group. Must not be
     *     {@code null}.
     *
     * @return builder for this class.
     *
     * @throws IllegalArgumentException  If any argument does not meet its
     *     preconditions.
     */
    public static Builder newBuilder(AccessLevel accessType, GroupInfo group) {
        return new Builder(accessType, group);
    }

    /**
     * Builder for {@link GroupMembershipInfo}.
     */
    public static class Builder extends MembershipInfo.Builder {
        protected final GroupInfo group;

        protected Builder(AccessLevel accessType, GroupInfo group) {
            super(accessType);
            if (group == null) {
                throw new IllegalArgumentException("Required value for 'group' is null");
            }
            this.group = group;
        }

        /**
         * Builds an instance of {@link GroupMembershipInfo} configured with
         * this builder's values
         *
         * @return new instance of {@link GroupMembershipInfo}
         */
        public GroupMembershipInfo build() {
            return new GroupMembershipInfo(accessType, group, permissions, initials, isInherited);
        }
    }

    @Override
    public int hashCode() {
        int hash = java.util.Arrays.hashCode(new Object [] {
            group
        });
        hash = (31 * super.hashCode()) + hash;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        // be careful with inheritance
        else if (obj.getClass().equals(this.getClass())) {
            GroupMembershipInfo other = (GroupMembershipInfo) obj;
            return ((this.group == other.group) || (this.group.equals(other.group)))
                && ((this.getAccessType() == other.getAccessType()) || (this.getAccessType().equals(other.getAccessType())))
                && ((this.getPermissions() == other.getPermissions()) || (this.getPermissions() != null && this.getPermissions().equals(other.getPermissions())))
                && ((this.getInitials() == other.getInitials()) || (this.getInitials() != null && this.getInitials().equals(other.getInitials())))
                && (this.getIsInherited() == other.getIsInherited())
                ;
        }
        else {
            return false;
        }
    }

    @Override
    public String toString() {
        return _JSON_WRITER.writeToString(this, false);
    }

    public String toStringMultiline() {
        return _JSON_WRITER.writeToString(this, true);
    }

    public String toJson(Boolean longForm) {
        return _JSON_WRITER.writeToString(this, longForm);
    }

    public static GroupMembershipInfo fromJson(String s) throws JsonReadException {
        return _JSON_READER.readFully(s);
    }

    public static final JsonWriter<GroupMembershipInfo> _JSON_WRITER = new JsonWriter<GroupMembershipInfo>() {
        public final void write(GroupMembershipInfo x, JsonGenerator g) throws IOException {
            g.writeStartObject();
            MembershipInfo._JSON_WRITER.writeFields(x, g);
            GroupMembershipInfo._JSON_WRITER.writeFields(x, g);
            g.writeEndObject();
        }
        public final void writeFields(GroupMembershipInfo x, JsonGenerator g) throws IOException {
            g.writeFieldName("group");
            GroupInfo._JSON_WRITER.write(x.group, g);
        }
    };

    public static final JsonReader<GroupMembershipInfo> _JSON_READER = new JsonReader<GroupMembershipInfo>() {
        public final GroupMembershipInfo read(JsonParser parser) throws IOException, JsonReadException {
            GroupMembershipInfo result;
            JsonReader.expectObjectStart(parser);
            result = readFields(parser);
            JsonReader.expectObjectEnd(parser);
            return result;
        }

        public final GroupMembershipInfo readFields(JsonParser parser) throws IOException, JsonReadException {
            AccessLevel accessType = null;
            GroupInfo group = null;
            List<MemberPermission> permissions = null;
            String initials = null;
            Boolean isInherited = null;
            while (parser.getCurrentToken() == JsonToken.FIELD_NAME) {
                String fieldName = parser.getCurrentName();
                parser.nextToken();
                if ("access_type".equals(fieldName)) {
                    accessType = AccessLevel._JSON_READER
                        .readField(parser, "access_type", accessType);
                }
                else if ("group".equals(fieldName)) {
                    group = GroupInfo._JSON_READER
                        .readField(parser, "group", group);
                }
                else if ("permissions".equals(fieldName)) {
                    permissions = JsonArrayReader.mk(MemberPermission._JSON_READER)
                        .readField(parser, "permissions", permissions);
                }
                else if ("initials".equals(fieldName)) {
                    initials = JsonReader.StringReader
                        .readField(parser, "initials", initials);
                }
                else if ("is_inherited".equals(fieldName)) {
                    isInherited = JsonReader.BooleanReader
                        .readField(parser, "is_inherited", isInherited);
                }
                else {
                    JsonReader.skipValue(parser);
                }
            }
            if (accessType == null) {
                throw new JsonReadException("Required field \"access_type\" is missing.", parser.getTokenLocation());
            }
            if (group == null) {
                throw new JsonReadException("Required field \"group\" is missing.", parser.getTokenLocation());
            }
            return new GroupMembershipInfo(accessType, group, permissions, initials, isInherited);
        }
    };
}
