import React, { Component } from 'react';

export default class SearchList extends Component {
  closeList = () => {
    this.setState({showList: false});
  }
  state = {
    showList: this.checkLength(this.props.users),
  }
  componentWillReceiveProps(props) {    
    //componentWillReceiveProps여기서는 부모 구성 요소가 현재 속성에 새 속성을 설정할 때마다 실행되는 함수를 사용합니다.
    this.showList(props.users);
  }
  checkLength(users) {
    if(users.length > 0) {
      document.addEventListener('click', this.closeList);
      return true;
    } else {
      return false;
    }
  }
  showList(users) {
    if(this.checkLength(users)) {
      this.setState({showList: true});
    } else {
      this.closeList();
    }
  }
  componentWillUnmount() {
    document.removeEventListener('click', this.closeList);
  }
  render() {
    const { users } = this.props;
    const { showList } = this.state;
    return (
      showList && 
        <div className="result">
          {users.map((user, i) => 
            <div key={user.id} className="user">
              <img src={user.avatar} />
              <span>{user.username}</span>
            </div>
          )}
        </div>
    )
  }
}