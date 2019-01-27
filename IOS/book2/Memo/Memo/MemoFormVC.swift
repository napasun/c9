//
//  MemoFormVC.swift
//  Memo
//
//  Created by estgames on 2017. 12. 14..
//  Copyright © 2017년 estgames. All rights reserved.
//

import UIKit
                                    //이미지 피커 컨트롤러의 델리게이트 메소드 구현시 필요한 것들, 텍스트뷰 델리게이트
class MemoFormVC: UIViewController, UIImagePickerControllerDelegate, UINavigationControllerDelegate, UITextViewDelegate {
    var subject : String!
    @IBOutlet var content: UITextView!
    @IBOutlet var preview: UIImageView!
    
    //저장 버튼 클릭시
    @IBAction func save(_ sender: Any) {
        guard self.content.text.isEmpty == false else { //내용을 입력하지 않았을 경우 경고창을 띄운다.
            let alert = UIAlertController(title: nil, message: "내용을 입력해주세요", preferredStyle: .alert)
            alert.addAction(UIAlertAction(title: "OK", style: .default, handler: nil))
            self.present(alert, animated: true)
            
            return
        }
        //메모데이터 객체를 생성하고 데이터를 넣는 다.
        let data = MemoData()
        
        data.title = self.subject
        data.contents = self.content.text
        data.image = self.preview.image
        data.regdate = Date()
        
        //앱 델리게이트 객체를 읽어와서 메모배열에 객체를 추가한다.
        let appDelegate = UIApplication.shared.delegate as! AppDelegate
        appDelegate.memolist.append(data)
        
        //작성폼 화면 종료, 이전화면으로 돌아가기
        _ = self.navigationController?.popViewController(animated: true)
    }
    //카메라 버튼 클릭
    @IBAction func pick(_ sender: Any) {
        let picker = UIImagePickerController()    //이미지 피커 인스턴스 생성
        
        picker.delegate = self  //델리게이트 설정
        picker.allowsEditing = true //이미지 피커 컨트롤러의 이미지 편집을 허용
        
        self.present(picker, animated: false)   //화면에 표시
    }
    
    override func viewDidLoad() {
        super.viewDidLoad()

        // Do any additional setup after loading the view.
        self.content.delegate = self    //텍스트 뷰의 델리게이트설정
    }

    override func didReceiveMemoryWarning() {
        super.didReceiveMemoryWarning()
        // Dispose of any resources that can be recreated.
    }
    
    //이미지 선택을 완료했을 때 호출되는 메서드
    func imagePickerController(_ picker: UIImagePickerController, didFinishPickingMediaWithInfo info: [String : Any]) {
        // 선택된 이미지를 미리보기 표시
        self.preview.image = info[UIImagePickerControllerEditedImage] as? UIImage
        
        picker.dismiss(animated: false) //이미지 피커 컨트롤을 닫는다.
    }

    //텍스트뷰에서 입력이 있을 때 호출되는 메서드
    func textViewDidChange(_ textView: UITextView) {
        //내용의 15자리까지 읽어 제목으로 만든다.
        let content = textView.text as NSString
        let length = ((content.length > 15) ? 15 : content.length)
        self.subject = content.substring(with: NSRange(location: 0, length: length))
        
        self.navigationItem.title = subject //네이게이션 타이틀에 표시한다.
    }
    /*
    // MARK: - Navigation

    // In a storyboard-based application, you will often want to do a little preparation before navigation
    override func prepare(for segue: UIStoryboardSegue, sender: Any?) {
        // Get the new view controller using segue.destinationViewController.
        // Pass the selected object to the new view controller.
    }
    */

}
