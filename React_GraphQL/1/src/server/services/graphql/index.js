import { ApolloServer } from 'apollo-server-express';
import { makeExecutableSchema } from 'graphql-tools';
import Resolvers from './resolvers';
import Schema from './schema';
import auth from './auth';
import JWT from 'jsonwebtoken';
const { JWT_SECRET } = process.env;

export default (utils) => {
  const executableSchema = makeExecutableSchema({ // 스키마를 결함
    typeDefs: Schema,
    resolvers: Resolvers.call(utils),
    schemaDirectives: {
      auth: auth
    },
  });
  const server = new ApolloServer({
    schema: executableSchema,
    context: async ({ req }) => {
      const authorization = req.headers.authorization;
      if(typeof authorization !== typeof undefined) {
        var search = "Bearer";
        var regEx = new RegExp(search, "ig");
        const token = authorization.replace(regEx, '').trim();
        return jwt.verify(token, JWT_SECRET, function(err, result) {
          return req;
        });
      } else {
        return req;
      }
    },
  });

    // const executableSchema = makeExecutableSchema({
    //   typeDefs: Schema,
    //   resolvers: Resolvers.call(utils),
    // });
   
    // const server = new ApolloServer({
    //   schema: executableSchema,
    //   context: ({ req }) => req,
    // });
    
    return server;
};