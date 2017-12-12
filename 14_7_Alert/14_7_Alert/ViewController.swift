//
//  ViewController.swift
//  14_7_Alert
//
//  Created by estgames on 2017. 12. 12..
//  Copyright © 2017년 estgames. All rights reserved.
//

import UIKit

class ViewController: UIViewController {

    @IBAction func showAlert(_ sender: Any) {
        // 알람을 만든다
        let alert = UIAlertController(title: nil, message: nil, preferredStyle: .alert)
        alert.title = "타이틀"
        alert.message = "메세지 글"
        
        // 버튼1
        alert.addAction(
            UIAlertAction(
                title: "버튼１입니다",
                style: .default,
                handler: {(action) -> Void in
                    self.hello(action.title!)
            })
        )
        
        // 버튼２
        alert.addAction(
            UIAlertAction(
                title: "버튼２입니다",
                style: .default,
                handler: {(action) -> Void  in
                    self.hello(action.title!)
            })
        )
        
        // 취소（추가 순서와 상관없이 마지막에 표시된다）
        alert.addAction(
            UIAlertAction(
                title: "취소",
                style: .cancel,
                handler: nil)
        )
        
        
        // 빨간 버튼
        alert.addAction(
            UIAlertAction(
                title: "삭제합니다",
                style: .destructive,
                handler: {(action) -> Void in
                    self.hello(action.title!)
            })
        )
        
        // 알람을 표시한다
        self.present(
            alert,
            animated: true,
            completion: {
                // 표시 종료 후에 실해
                print("알람이 표시되었다")
        }
        )
    }
    
    // 선택으로 실행되는 메서드
    func hello(_ msg:String) {
        print(msg)
    }
    
    override func viewDidLoad() {
        super.viewDidLoad()
        // Do any additional setup after loading the view, typically from a nib.
        
    }

    override func didReceiveMemoryWarning() {
        super.didReceiveMemoryWarning()
        // Dispose of any resources that can be recreated.
    }


}

