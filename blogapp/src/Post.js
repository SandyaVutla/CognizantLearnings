// src/Post.js
import React from 'react';

class Post extends React.Component {
  render() {
    const { title, body } = this.props;
    return (
      <div className="post">
        <h3>{title}</h3>
        <p>{body}</p>
        <hr />
      </div>
    );
  }
}

export default Post;
