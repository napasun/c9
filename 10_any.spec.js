jest.mock('./10_request');
const user = require ("./10_user")

// it('works with promises', () => {
//   expect.assertions(1);
//   return user.getUserName(4).then(data => expect(data).toEqual('M1ark'));
// });

it('works with promises', () => {
    expect.assertions(1);
    return user.getUserName(4).then(data => expect(data).toEqual('Mark'));
  });