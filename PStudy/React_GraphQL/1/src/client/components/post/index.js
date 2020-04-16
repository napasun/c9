import React, { Component } from 'react';
import PostHeader from './header';
import PostContent from './content';
import PropTypes from 'prop-types';

export default class Post extends Component {
  /*
    이 PropTypes패키지는 우리가 사용할 수있는 다양한 유형을 제공합니다. 로 각 유형에 액세스 할 수 있습니다 PropTypes.X. 
    필수 특성 인 isRequired 경우 앞의 코드와 같은 방식으로 단어 를 추가 할 수 있습니다  .
  */
  static propTypes = {
    //post: PropTypes.object.isRequired,  //post 객체가 반드시 필요하다. 주석이 설명으로 들어간다.
    /** Object containing the complete post. */
    post: PropTypes.shape({
      id: PropTypes.number.isRequired,
      text: PropTypes.string.isRequired,
      user: PropTypes.shape({
        avatar: PropTypes.string.isRequired,
        username: PropTypes.string.isRequired,
      }).isRequired
    }).isRequired,
  }



  render() {
    const { post } = this.props;

    return (
      <div className={"post " + (post.id < 0 ? "optimistic": "")}>
        <PostHeader post={post}/>
        <PostContent post={post}/>
      </div>
    )
  }
}