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
            // <Query query={GET_POSTS} variables={{ page: 0, limit: 10 }}>
            //     {({ loading, error, data, fetchMore }) => {
            //         if (loading) return <Loading />;
            //         if (error) return <Error />;

            //         const { postsFeed } = data;
            //         const { posts } = postsFeed;

            //         return (
            //             <div className="container">
            //                 <div className="postForm">
            //                     <Mutation mutation={ADD_POST}
            //                         update={(store, { data: { addPost } }) => {
            //                             const variables = { page: 0, limit: 10 };
            //                             const data = store.readQuery({ query: GET_POSTS, variables });
            //                             data.postsFeed.posts.unshift(addPost);
            //                             store.writeQuery({ query: GET_POSTS, variables, data });
            //                         }}
            //                         optimisticResponse={{
            //                             __typename: "Mutation",
            //                             addPost: {
            //                                 __typename: "Post",
            //                                 text: postContent,
            //                                 id: -1,
            //                                 user: {
            //                                     __typename: "User",
            //                                     username: "Loading...",
            //                                     avatar: "/public/loading.gif"
            //                                 }
            //                             }
            //                         }}>
            //                         {addPost => (
            //                             <form onSubmit={e => {
            //                                 e.preventDefault();
            //                                 addPost({ variables: { post: { text: postContent } } }).then(() => {
            //                                     self.setState((prevState) => ({
            //                                         postContent: ''
            //                                     }));
            //                                 });
            //                             }}>
            //                                 <textarea value={postContent} onChange={self.handlePostContentChange} placeholder="Write your custom post!" />
            //                                 <input type="submit" value="Submit" />
            //                             </form>
            //                         )}
            //                     </Mutation>
            //                 </div>
            //                 <div className="feed">
            //                     <InfiniteScroll
            //                         loadMore={() => self.loadMore(fetchMore)}
            //                         hasMore={hasMore}
            //                         loader={<div className="loader" key={"loader"}>Loading ...</div>}
            //                     >
            //                         {posts.map((post, i) =>
            //                             <Post key={post.id} post={post} />
            //                         )}
            //                     </InfiniteScroll>
            //                 </div>
            //             </div>
            //         )
            //     }}
            // </Query>
        )
    }
}