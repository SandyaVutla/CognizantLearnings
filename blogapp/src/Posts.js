// src/Posts.js
import React from 'react';
import Post from './Post';

class Posts extends React.Component {
  constructor(props) {
    super(props);
    this.state = {
      posts: [],
      hasError: false
    };
  }

  // Lifecycle method: Fetch data
  componentDidMount() {
    this.loadPosts();
  }

  // Fetching post data
  loadPosts() {
    fetch('https://jsonplaceholder.typicode.com/posts')
      .then(res => res.json())
      .then(data => {
        this.setState({ posts: data });
      })
      .catch(err => {
        console.error('Error fetching posts:', err);
        this.setState({ hasError: true });
      });
  }

  // Error boundary
  componentDidCatch(error, info) {
    alert('An error occurred while loading posts.');
    console.error("Error caught in componentDidCatch:", error, info);
  }

  render() {
    return (
      <div>
        <h2>Blog Posts</h2>
        {this.state.posts.map(post => (
          <Post key={post.id} title={post.title} body={post.body} />
        ))}
      </div>
    );
  }
}

export default Posts;
