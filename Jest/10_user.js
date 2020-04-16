const request = require("./10_request")

exports.getUserName = function (userID) {
  return request.request('/users/' + userID).then(user => user.name);
}