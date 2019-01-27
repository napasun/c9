//: Playground - noun: a place where people can play

import UIKit

var str = "Hello, playground"


/**
 23장 프로토콜 지향 프로그래밍
 */

protocol Receiveable {
    func received(data: Any, from: Sendable)
}

extension Receiveable {
    func received(data: Any, from: Sendable) {  //메시지를 수신
        print("\(self) received \(data) from \(from)")
    }
}

protocol Sendable {
    var from: Sendable {get}
    var to: Receiveable? {get}
    
    func send(data: Any)
    
    static func isSendableInstance(_ instance: Any) -> Bool
}

extension Sendable {
    var from: Sendable {
        return self
    }
    
    func send (data: Any) {
        guard let receiver: Receiveable = self.to else {
            print("Message has no receiver")
            return
        }
        
        receiver.received(data: data, from: self.from)
    }
    
    static func isSendableInstance(_ instance: Any) -> Bool {
        if let sendableInstance: Sendable = instance as? Sendable {
            return sendableInstance.to != nil
        }
        return false
    }
}



class Mail: Sendable, Receiveable {
    var to: Receiveable?
    
    func send(data: Any) {
        print("Mail의 send 메서드 재정의")
    }
}

let mailInstance: Mail = Mail()
mailInstance.send(data: "Hello")
