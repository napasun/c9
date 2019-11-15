import React, { Component } from 'react';
import FeedList from './components/post/feedlist';
import PostsFeed from './components/queries/postsFeed';
import PostForm from './components/post/form';
import AddPostMutation from './components/mutations/addPost';

export default class Feed extends Component {
    render() {
        const query_variables = { page: 0, limit: 10};

        return (
            <div className="container">
                <AddPostMutation variables={query_variables}>
                    <PostForm />
                </AddPostMutation>
                <PostsFeed variables={query_variables}>
                <   FeedList/>
                </PostsFeed>
            </div>
        )
    }
}