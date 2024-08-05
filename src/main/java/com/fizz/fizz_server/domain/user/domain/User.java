package com.fizz.fizz_server.domain.user.domain;

import com.fizz.fizz_server.domain.category.domain.CategoryRecommendation;
import com.fizz.fizz_server.domain.challenge.domain.Challenge;
import com.fizz.fizz_server.domain.challenge.domain.Participant;
import com.fizz.fizz_server.domain.comment.domain.Comment;
import com.fizz.fizz_server.domain.comment.domain.CommentLike;
import com.fizz.fizz_server.domain.post.domain.Post;
import com.fizz.fizz_server.domain.post.domain.PostLike;
import com.fizz.fizz_server.global.base.domain.BaseEntity;
import com.fizz.fizz_server.global.oauth2.user.OAuth2Provider;
import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
public class User extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    private Long id;

    @Setter
    private String nickname;

    @Setter
    @Column(unique = true)
    private String email;

    private OAuth2Provider provider;
    private String providerId;

    @Setter
    @Column(unique = true)
    private String profileId;

    @Setter
    private String profileImage;

    @Setter
    private String aboutMe; // 자기소개

    @Setter
    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private RoleType role;

    @OneToMany(mappedBy = "follower", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<Follow> followers = new HashSet<>();

    @OneToMany(mappedBy = "followee", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<Follow> followees = new HashSet<>();

    @OneToMany(mappedBy = "user", cascade = CascadeType.REMOVE)
    private List<Post> posts = new ArrayList<>();

    @OneToMany(mappedBy = "user", cascade = CascadeType.REMOVE)
    private List<Comment> comments = new ArrayList<>();

    @OneToMany(mappedBy = "creator", cascade = CascadeType.REMOVE)
    private List<Challenge> createdChallenges = new ArrayList<>();

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<PostLike> postLikes = new HashSet<>();

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<CommentLike> commentLikes = new HashSet<>();

    @OneToMany(mappedBy = "user", cascade = CascadeType.REMOVE)
    private List<Participant> participants = new ArrayList<>();

    @OneToMany(mappedBy = "user", cascade = CascadeType.REMOVE)
    private List<CategoryRecommendation> recommendations = new ArrayList<>();


    @Builder
    public User(OAuth2Provider provider, String providerId, String nickname, String profileId, String profileImage, String email, String aboutMe, RoleType role) {
        this.provider = provider;
        this.providerId = providerId;
        this.nickname = nickname;
        this.profileId = profileId;
        this.profileImage = profileImage;
        this.email = email;
        this.aboutMe = aboutMe;
        this.role = role;
    }
}
