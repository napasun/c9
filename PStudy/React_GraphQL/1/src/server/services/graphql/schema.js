//directive @auth on QUERY | FIELD_DEFINITION | FIELD
//이 작은 스니펫은 Apollo 서버에 @auth지시문을 쿼리, 필드 및 필드 정의와 함께 사용하여 모든 곳에서 사용할 수 있음을 알려줍니다 .
const typeDefinitions = `
directive @auth on QUERY | FIELD_DEFINITION | FIELD

  type User {
    id: Int
    avatar: String
    username: String
    email: String
  }

  type Post {
    id: Int
    text: String
    user: User
  }

  type Message {
    id: Int
    text: String
    chat: Chat
    user: User
  }

  type Chat {
    id: Int
    messages: [Message]
    users: [User]
    lastMessage: Message
  }

  type PostFeed {
    posts: [Post]
  }

  type Response {
    success: Boolean
  }

  input PostInput {
    text: String!
  }

  type UsersSearch {
    users: [User]
  }

  type Auth {
    token: String
  }
  
  input UserInput {
    username: String!
    avatar: String!
  }

  input ChatInput {
    users: [Int]
  }

  input MessageInput {
    text: String!
    chatId: Int!
  }
  
  
  type RootQuery {
    posts: [Post]
    chats: [Chat]
    chat(chatId: Int): Chat
    postsFeed(page: Int, limit: Int, username: String): PostFeed @auth
    user(username: String!): User @auth
    usersSearch(page: Int, limit: Int, text: String!): UsersSearch
    currentUser: User @auth
  }

  type RootMutation {
    addPost (
      post: PostInput!
    ): Post
    addChat (
      chat: ChatInput!
    ): Chat
    addMessage (
      message: MessageInput!
    ): Message
    updatePost (
      post: PostInput!
      postId: Int!
    ): Post
    deletePost (
      postId: Int!
    ): Response
    login (
      email: String!
      password: String!
    ): Auth
    signup (
      username: String!
      email: String!
      password: String!
    ): Auth
  }

  schema {
    query: RootQuery
    mutation: RootMutation
  }
`;

export default [typeDefinitions];