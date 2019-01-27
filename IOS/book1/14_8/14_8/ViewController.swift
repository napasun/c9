//
//  ViewController.swift
//  14_8
//
//  Created by estgames on 2017. 12. 12..
//  Copyright © 2017년 estgames. All rights reserved.
//

import UIKit

class ViewController: UIViewController {

    @IBAction func showActionSheet(_ sender: Any) {
        // 액션시트를 만든다
        let actionSheet = UIAlertController(
            title: "타이틀",
            message: "메세지 글",
            preferredStyle: .actionSheet
        )
        
        // 버튼1
        actionSheet.addAction(
            UIAlertAction(
                title: "버튼１입니다",
                style: .default,
                handler: {(action) -> Void in
                    self.hello(action.title!)
            })
        )
        
        // 버튼２
        actionSheet.addAction(
            UIAlertAction(
                title: "버튼２입니다",
                style: .default,
                handler: {(action) -> Void  in
                    self.hello(action.title!)
            })
        )
        
        // 취소（추가 순서와 관계없이 마지막에 표시된다）
        actionSheet.addAction(
            UIAlertAction(
                title: "취소",
                style: .cancel,
                handler: nil)
        )
        
        
        // 빨간색 버튼
        actionSheet.addAction(
            UIAlertAction(
                title: "삭제합니다",
                style: .destructive,
                handler: {(action) -> Void in
                    self.hello(action.title!)
            })
        )
        
        // 액션시트를 표시한다
        self.present(
            actionSheet,
            animated: true,
            completion: {
                // 표시 종료 후에 실행
                print("액션 시트가 표시되었다")
        }
        )
    }
    
    // 선택된 버튼으로 실행되는 메서드
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

